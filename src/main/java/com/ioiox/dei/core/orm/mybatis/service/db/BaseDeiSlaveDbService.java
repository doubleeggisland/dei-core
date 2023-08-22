package com.ioiox.dei.core.orm.mybatis.service.db;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.orm.mybatis.mapper.AbstractDeiSlaveMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class BaseDeiSlaveDbService<T, M extends AbstractDeiSlaveMapper<T>>
        implements IBaseDeiSlaveDbService<T> {

    protected abstract M getMapper();

    /**
     * 服务类的描述信息
     */
    protected abstract String getDesc();

    @Override
    public int countByParams(final Map<String, Object> params) {
        final int count;
        try {
            count = getMapper().countByParams(params);
        } catch (Exception e) {
            throw new DeiDbException(String.format("统计%s记录数量出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return count;
    }

    @Override
    public List<T> findByParams(final Map<String, Object> params) {
        final List<T> entities;
        try {
            entities = getMapper().findByParams(params);
        } catch (Exception e) {
            throw new DeiDbException(String.format("查询%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return entities;
    }

    protected List<T> findByParamsOnSelective(final Map<String, Object> params) {
        final List<T> entities;
        try {
            entities = getMapper().findByParamsOnSelective(params);
        } catch (Exception e) {
            throw new DeiDbException(String.format("查询%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return entities;
    }

    @Override
    public List<T> findByParams(final Map<String, Object> params, final List<String> showColumns) {
        List<T> entities;
        if (Objects.isNull(showColumns) || showColumns.isEmpty()) {
            entities = findByParams(params);
        } else {
            showColumns.forEach((showColumn) ->
                    params.put(String.format("%sShow", showColumn), DeiGlobalConstant.FLAG_YES));
            entities = findByParamsOnSelective(params);
        }
        return Objects.isNull(entities) || entities.isEmpty()
                ? Collections.emptyList() : entities;
    }
}
