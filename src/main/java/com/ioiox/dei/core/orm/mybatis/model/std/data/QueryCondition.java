package com.ioiox.dei.core.orm.mybatis.model.std.data;

public class QueryCondition<T> {
    public static final String PARAM_NAME_PKS = "sids";
    public static final String PARAM_NAME_PK = "sid";
    public static final String PARAM_NAME_LIMIT = "limit";
    public static final String PARAM_NAME_OFFSET = "offset";
    public static final String PARAM_NAME_ORDER_BY_CLAUSE = "orderByClause";

    private String paramName;
    private T paramValue;

    public QueryCondition() {

    }

    public QueryCondition(final String paramName, final T paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public T getParamValue() {
        return paramValue;
    }
}
