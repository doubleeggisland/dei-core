package com.ioiox.dei.core.utils;

import java.util.List;

public class RelationshipsAnalyser {

    public static <T> DiffHolder<T> analysisDiff(final List<T> relationships,
                                                 final List<T> existingRelationships) {
        final DiffHolder<T> diffHolder = new DiffHolder<>();
        if (DeiCollectionUtil.isEmpty(relationships)
                && DeiCollectionUtil.isEmpty(existingRelationships)) {
            return diffHolder;
        }
        if (DeiCollectionUtil.isEmpty(relationships)
                && DeiCollectionUtil.isNotEmpty(existingRelationships)) {
            diffHolder.setRemovedRelationships(existingRelationships);
        }
        if (DeiCollectionUtil.isNotEmpty(relationships)
                && DeiCollectionUtil.isEmpty(existingRelationships)) {
            diffHolder.setNewRelationships(relationships);
        }
        final List<T> intersections = DeiCollectionUtil.getIntersection(relationships, existingRelationships);
        final List<T> newRelationships = DeiCollectionUtil.getDifference(relationships, intersections);
        final List<T> removedRelationships = DeiCollectionUtil.getDifference(existingRelationships, intersections);
        diffHolder.setNewRelationships(newRelationships);
        diffHolder.setRemovedRelationships(removedRelationships);
        return diffHolder;
    }

    public static class DiffHolder<T> {
        private List<T> newRelationships;
        private List<T> removedRelationships;

        public DiffHolder() {}

        public DiffHolder(final List<T> newRelationships,
                          final List<T> removedRelationships) {
            this.newRelationships = newRelationships;
            this.removedRelationships = removedRelationships;
        }

        public List<T> getNewRelationships() {
            return newRelationships;
        }

        public void setNewRelationships(final List<T> newRelationships) {
            this.newRelationships = newRelationships;
        }

        public List<T> getRemovedRelationships() {
            return removedRelationships;
        }

        public void setRemovedRelationships(final List<T> removedRelationships) {
            this.removedRelationships = removedRelationships;
        }
    }
}
