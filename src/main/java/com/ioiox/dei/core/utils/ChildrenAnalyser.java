package com.ioiox.dei.core.utils;

import com.ioiox.dei.core.vo.MasterStdDataVO;
import com.ioiox.dei.core.vo.SlaveStdDataVO;

import java.util.*;
import java.util.stream.Collectors;

public class ChildrenAnalyser {

    public static <M extends MasterStdDataVO, S extends SlaveStdDataVO> DiffHolder<M, S> analysisDiff(final List<M> children,
                                                                                                      final List<S> existingChildren) {
        final DiffHolder<M, S> diffHolder = new DiffHolder<>();
        if (DeiCollectionUtil.isEmpty(children)
                && DeiCollectionUtil.isEmpty(existingChildren)) {
            return diffHolder;
        }
        if (DeiCollectionUtil.isNotEmpty(children)
                && DeiCollectionUtil.isEmpty(existingChildren)) {
            children.forEach(diffHolder::addNewChild);
            return diffHolder;
        }
        if (DeiCollectionUtil.isEmpty(children)
                && DeiCollectionUtil.isNotEmpty(existingChildren)) {
            existingChildren.forEach(diffHolder::addRemovedChild);
            return diffHolder;
        }

        final Map<Long, M> childMap = children.stream().filter(item -> Objects.nonNull(item.getId()))
                .collect(Collectors.toMap(M::getId, item -> item));
        final Map<Long, S> existingChildMap = existingChildren.stream()
                .collect(Collectors.toMap(S::getId, item -> item));
        final Set<Long> idsOfIntersection;
        final Set<Long> childIds = DeiCollectionUtil.isEmpty(childMap) ? null : childMap.keySet();
        final Set<Long> existingChildIds = existingChildMap.keySet();
        if (DeiCollectionUtil.isNotEmpty(childIds)) {
            idsOfIntersection = DeiCollectionUtil.getIntersection(childIds, existingChildIds);
        } else {
            idsOfIntersection = Collections.emptySet();
        }
        final Map<Long, ChildHolder<M, S>> childHolders = new HashMap<>(idsOfIntersection.size());
        for (final Long id : idsOfIntersection) {
            final M child = childMap.get(id);
            final S existingChild = existingChildMap.get(id);
            final ChildHolder<M, S> childHolder = new ChildHolder<>(child, existingChild);
            childHolders.put(childHolder.id, childHolder);
        }

        final Map<String, M> restChildMap = children.stream().filter(item -> Objects.isNull(item.getId()) || !childHolders.containsKey(item.getId()))
                .collect(Collectors.toMap(M::uniqueKeyDigest, item -> item));
        final Map<String, S> restExistingChildMap = existingChildren.stream().filter(item -> !childHolders.containsKey(item.getId()))
                .collect(Collectors.toMap(S::uniqueKeyDigest, item -> item));
        final Set<String> mergedUniqueKeyDigests = new HashSet<>(restChildMap.keySet());
        mergedUniqueKeyDigests.addAll(restExistingChildMap.keySet());
        for (final String uniqueKeyDigest : mergedUniqueKeyDigests) {
            final M restChild = restChildMap.get(uniqueKeyDigest);
            final S restExistingChild = restExistingChildMap.get(uniqueKeyDigest);
            if (Objects.nonNull(restChild)
                    && Objects.nonNull(restExistingChild)) {
                final ChildHolder<M, S> childHolder = new ChildHolder<>(restChild, restExistingChild);
                diffHolder.addUpdatableChild(childHolder);
            } else {
                if (Objects.isNull(restChild)) {
                    diffHolder.addRemovedChild(restExistingChild);
                } else {
                    diffHolder.addNewChild(restChild);
                }
            }
        }

        childHolders.values().forEach(diffHolder::addUpdatableChild);
        return diffHolder;
    }

    public static class DiffHolder<M extends MasterStdDataVO, S extends SlaveStdDataVO> {
        private final List<M> newChildren;
        private final List<ChildHolder<M, S>> updatableChildren;
        private final List<S> removedChildren;

        public DiffHolder() {
            newChildren = new LinkedList<>();
            updatableChildren = new LinkedList<>();
            removedChildren = new LinkedList<>();
        };

        public List<M> getNewChildren() {
            return newChildren;
        }

        public List<ChildHolder<M, S>> getUpdatableChildren() {
            return updatableChildren;
        }

        public List<S> getRemovedChildren() {
            return removedChildren;
        }

        public void addNewChild(final M newChild) {
            this.newChildren.add(newChild);
        }

        public void addUpdatableChild(final ChildHolder<M, S> updatableChild) {
            this.updatableChildren.add(updatableChild);
        }

        public void addRemovedChild(final S removedChild) {
            this.removedChildren.add(removedChild);
        }
    }


    public static class ChildHolder<M extends MasterStdDataVO, S extends SlaveStdDataVO> {
        private Long id;
        private M child;
        private S existingChild;

        public ChildHolder() {}

        public ChildHolder(final M child, final S existingChild) {
            if (Objects.nonNull(child.getId())) {
                id = child.getId();
            } else {
                id = existingChild.getId();
            }
            this.child = child;
            this.existingChild = existingChild;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public M getChild() {
            return child;
        }

        public void setChild(final M child) {
            this.child = child;
        }

        public S getExistingChild() {
            return existingChild;
        }

        public void setExistingChild(final S existingChild) {
            this.existingChild = existingChild;
        }
    }
}
