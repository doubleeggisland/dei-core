package com.ioiox.dei.core.orm.mybatis.model.std.data;

public class DeleteCondition<T> {
    private final String paramName;
    private final T paramValue;

    public DeleteCondition(final String paramName, final T paramValue) {
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
