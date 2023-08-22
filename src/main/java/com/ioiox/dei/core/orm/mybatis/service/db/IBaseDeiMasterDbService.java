package com.ioiox.dei.core.orm.mybatis.service.db;

import java.util.List;
import java.util.Map;

public interface IBaseDeiMasterDbService<T> {
    int dbInsert(final T newEntity);
    int dbInsert(final List<T> newEntities);
    int dbUpdate(final T example);
    int dbUpdateByParams(final Map<String, Object> params,
                         final Map<String, Object> conditions);
    int deleteByParams(final Map<String, Object> params);
}
