package com.ioiox.dei.core.vo;

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
