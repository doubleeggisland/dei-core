package com.ioiox.dei.core.orm.mybatis.model.std.data;

import java.util.*;

public class QueryConditionsHolder {
    private final List<QueryCondition<?>> queryConditions;

    public QueryConditionsHolder() {
        queryConditions = new LinkedList<>();
    }

    public void addQueryCondition(final String paramName, final Object paramValue) {
        addQueryCondition(new QueryCondition<>(paramName, paramValue));
    }

    public void addQueryCondition(final QueryCondition<?> queryCondition) {
        queryConditions.add(queryCondition);
    }

    public Map<String, Object> queryParams() {
        final Map<String, Object> queryParams = new HashMap<>(queryConditions.size());
        for (final QueryCondition<?> queryCondition : queryConditions) {
            queryParams.put(queryCondition.getParamName(), queryCondition.getParamValue());
        }
        return queryParams;
    }
}
