package com.ioiox.dei.core.utils;

import java.util.*;
import java.util.stream.Collectors;

public class DeiCollectionUtil {

    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(final Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <T> boolean isEmpty(final Collection<T> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static <T> boolean isNotEmpty(final Collection<T> collection) {
        return !isEmpty(collection);
    }

    public static <T> boolean identical(final Collection<T> first, final Collection<T> second) {
        if (isEmpty(first) && isEmpty(second)) {
            return true;
        }
        if (isEmpty(first) || isEmpty(second)) {
            return false;
        }
        if (first.size() != second.size()) {
            return false;
        }
        final Map<T, Long> firstMap = first.stream().collect(Collectors.groupingBy(element -> element, Collectors.counting()));
        final Map<T, Long> secondMap = second.stream().collect(Collectors.groupingBy(element -> element, Collectors.counting()));
        return Objects.equals(firstMap, secondMap);
    }

    /**
     * 获取first集合和second集合的交集
     */
    public static <T> Set<T> getIntersection(final Set<T> first, final Set<T> second) {
        final Set<T> copyOfFirst = new HashSet<>(first);
        copyOfFirst.retainAll(second);
        return copyOfFirst;
    }

    /**
     * 获取first集合中存在但在second集合中不存在的元素集合
     */
    public static <T> Set<T> getDifference(final Set<T> first, final Set<T> second) {
        final Set<T> copyOfFirst = new HashSet<>(first);
        copyOfFirst.removeAll(second);
        return copyOfFirst;
    }

    /**
     * 获取first集合和second集合的交集
     */
    public static <T> List<T> getIntersection(final List<T> first, final List<T> second) {
        final List<T> copyOfFirst = new ArrayList<>(first);
        copyOfFirst.retainAll(second);
        return copyOfFirst;
    }

    /**
     * 获取first集合中存在但在second集合中不存在的元素集合
     */
    public static <T> List<T> getDifference(final List<T> first, final List<T> second) {
        final List<T> copyOfFirst = new ArrayList<>(first);
        copyOfFirst.removeAll(second);
        return copyOfFirst;
    }

    public static <E> List<E> sublist(final List<E> source, final int startIdx, final int length) {
        if (isEmpty(source)) {
            return Collections.emptyList();
        }
        if (startIdx >= source.size()) {
            return Collections.emptyList();
        }
        final List<E> sublist = new ArrayList<>(length);
        for (int i = 0 ; i < length ; i++ ) {
            if (startIdx + i >= source.size()) {
                break;
            }
            sublist.add(source.get(startIdx + i));
        }
        return sublist;
    }
}
