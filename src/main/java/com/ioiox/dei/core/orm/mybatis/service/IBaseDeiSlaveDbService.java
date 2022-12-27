package com.ioiox.dei.core.orm.mybatis.service;

import java.util.List;
import java.util.Map;

public interface IBaseDeiSlaveDbService<T> {
    int countByParams(final Map<String, Object> params);
    List<T> findByParams(final Map<String, Object> params);
    List<T> findByParams(final Map<String, Object> params, final List<String> showColumns);
}
