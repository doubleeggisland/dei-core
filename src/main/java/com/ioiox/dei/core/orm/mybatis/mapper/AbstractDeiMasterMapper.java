package com.ioiox.dei.core.orm.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface AbstractDeiMasterMapper<T> {
    int insert(final T entity);
    int batchInsert(final List<T> entities);
    int updateByExample(final T example);
    int updateByParams(final Map<String, Object> params);
    int deleteByParams(final Map<String, Object> params);
}
