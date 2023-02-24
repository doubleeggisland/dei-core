package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.utils.DeiCollectionUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class UpdatableVO {

    public abstract Map<String, String> updateSummary();

    public static <T> boolean modified(final T oldVal, final T newVal) {
        return !Objects.equals(oldVal, newVal);
    }

    public static <T> boolean modified(final List<T> oldVal, final List<T> newVal) {
        return !DeiCollectionUtil.identical(oldVal, newVal);
    }

    public static <T> boolean modified(final Set<T> oldVal, final Set<T> newVal) {
        final Set<T> first = DeiCollectionUtil.isEmpty(oldVal) ? Collections.emptySet() : oldVal;
        final Set<T> second = DeiCollectionUtil.isEmpty(newVal) ? Collections.emptySet() : newVal;
        final Set<T> intersection = DeiCollectionUtil.getIntersection(first, second);
        final int sizeOfIntersection = intersection.size();
        return sizeOfIntersection != first.size() || sizeOfIntersection != second.size();
    }

    public static <K, V> boolean modified(final Map<K, V> oldVal, final Map<K, V> newVal) {
        final Map<K, V> oldMap = DeiCollectionUtil.isEmpty(oldVal) ? Collections.emptyMap() : oldVal;
        final Map<K, V> newMap = DeiCollectionUtil.isEmpty(newVal) ? Collections.emptyMap() : newVal;
        final Set<K> keySetOfOldMap = oldMap.keySet();
        final Set<K> keySetOfNewMap = newMap.keySet();
        if (modified(keySetOfOldMap, keySetOfNewMap)) {
            return true;
        } else {
            for (final K keyOfNewMap : keySetOfNewMap) {
                final V valOfOldMap = oldMap.get(keyOfNewMap);
                final V valOfNewMap = newMap.get(keyOfNewMap);
                if (!Objects.equals(valOfOldMap, valOfNewMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean decimalValModified(final BigDecimal oldVal, final BigDecimal newVal) {
        final double oldValPrimitive = Objects.isNull(oldVal) ? 0.00D : oldVal.setScale(2, RoundingMode.HALF_UP).doubleValue();
        final double newValPrimitive = Objects.isNull(newVal) ? 0.00D : newVal.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return oldValPrimitive != newValPrimitive;
    }
}
