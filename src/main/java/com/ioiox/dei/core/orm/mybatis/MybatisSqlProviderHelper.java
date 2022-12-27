package com.ioiox.dei.core.orm.mybatis;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MybatisSqlProviderHelper {

    public static String in (final String columnName, final String propertyName, final int qty) {
        final List<String> conditions = new ArrayList<>(qty);
        for (int i = 0 ; i < qty ; i++) {
            conditions.add(String.format("#{%s[%d]}", propertyName, i));
        }
        return String.format("%s in (%s)", columnName, StringUtils.join(conditions, ","));
    }

    public static String lessEqualThan(final String columnName, final String propertyName) {
        return String.format("%s <= #{%s}", columnName, propertyName);
    }

    public static String greaterEqualThan(final String columnName, final String propertyName) {
        return String.format("%s >= #{%s}", columnName, propertyName);
    }

    public static String lessThan(final String columnName, final String propertyName) {
        return String.format("%s < #{%s}", columnName, propertyName);
    }

    public static String greaterThan(final String columnName, final String propertyName) {
        return String.format("%s > #{%s}", columnName, propertyName);
    }

    public static String equal(final String columnName, final String propertyName) {
        return String.format("%s = #{%s}", columnName, propertyName);
    }
}
