package com.ioiox.dei.core.orm.mybatis.service;


import com.ioiox.dei.core.orm.mybatis.mapper.AbstractDeiMasterMapper;

import java.util.List;
import java.util.Map;

public abstract class BaseDeiMasterDbService <T, M extends AbstractDeiMasterMapper<T>>
        implements IBaseDeiMasterDbService<T> {

    protected abstract M getMapper();

    /**
     * 服务类的描述信息
     */
    protected abstract String getDesc();

    @Override
    public int dbInsert(T newEntity) {
        final int insertedRows;
        try {
            insertedRows = getMapper().insert(newEntity);
        } catch (Exception e) {
            throw new DeiDbException(String.format("新增%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return insertedRows;
    }

    @Override
    public int dbInsert(List<T> newEntities) {
        final int insertedRows;
        try {
            insertedRows = getMapper().batchInsert(newEntities);
        } catch (Exception e) {
            throw new DeiDbException(String.format("批量新增%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return insertedRows;
    }

    @Override
    public int dbUpdate(T example) {
        final int updatedRows;
        try {
            updatedRows = getMapper().updateByExample(example);
        } catch (Exception e) {
            throw new DeiDbException(String.format("更新%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return updatedRows;
    }

    @Override
    public int dbUpdateByParams(Map<String, Object> params) {
        final int updatedRows;
        try {
            updatedRows = getMapper().updateByParams(params);
        } catch (Exception e) {
            throw new DeiDbException(String.format("更新%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return updatedRows;
    }

    @Override
    public int deleteByParams(Map<String, Object> params) {
        final int deletedRows;
        try {
            deletedRows = getMapper().deleteByParams(params);
        } catch (Exception e) {
            throw new DeiDbException(String.format("删除%s记录出错, 错误信息: %s", getDesc(), e.getMessage()), e);
        }
        return deletedRows;
    }
}
