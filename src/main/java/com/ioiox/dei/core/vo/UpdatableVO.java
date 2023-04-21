package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.utils.DateUtil;
import com.ioiox.dei.core.utils.DeiCollectionUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class UpdatableVO {

    private Date lastModifiedTime;

    private final List<String> updatedAttrNames = new LinkedList<>();

    public boolean attrsUpdated() {
        return DeiCollectionUtil.isNotEmpty(updatedAttrNames);
    }

    public boolean attrsNotUpdated() {
        return DeiCollectionUtil.isEmpty(updatedAttrNames);
    }

    public boolean updated() {
        return Objects.nonNull(lastModifiedTime)
                || DeiCollectionUtil.isNotEmpty(updatedAttrNames);
    }

    public String formatLastModifiedTime() {
        return Objects.isNull(lastModifiedTime)
                ? DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(lastModifiedTime, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    public abstract Map<String, String> updateSummary();

    public void addUpdatedAttrName(final String updatedAttrName) {
        updatedAttrNames.add(updatedAttrName);
    }

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

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(final Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void updateLastModifiedTime() {
        setLastModifiedTime(new Date(System.currentTimeMillis()));
    }
}
