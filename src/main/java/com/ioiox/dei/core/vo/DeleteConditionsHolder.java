package com.ioiox.dei.core.vo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DeleteConditionsHolder {
    private final List<DeleteCondition<?>> deleteConditions;

    public DeleteConditionsHolder() {
        deleteConditions = new LinkedList<>();
    }

    public void addDeleteCondition(final String paramName, final Object paramValue) {
        addDeleteCondition(new DeleteCondition<>(paramName, paramValue));
    }

    public void addDeleteCondition(final DeleteCondition<?> deleteCondition) {
        deleteConditions.add(deleteCondition);
    }

    public Map<String, Object> deleteParams() {
        final Map<String, Object> deleteParams = new HashMap<>(deleteConditions.size());
        for (final DeleteCondition<?> deleteCondition : deleteConditions) {
            deleteParams.put(deleteCondition.getParamName(), deleteCondition.getParamValue());
        }
        return deleteParams;
    }
}
