package com.ioiox.dei.core.orm.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface AbstractDeiSlaveMapper<T> {
    int countByParams(final Map<String, Object> params);
    List<T> findByParams(final Map<String, Object> params);
    List<T> findByParamsOnSelective(final Map<String, Object> params);
}
