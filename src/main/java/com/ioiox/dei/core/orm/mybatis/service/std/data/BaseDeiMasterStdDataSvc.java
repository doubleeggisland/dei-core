package com.ioiox.dei.core.orm.mybatis.service.std.data;

import com.ioiox.dei.core.beans.BaseDeiEntity;
import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.orm.mybatis.model.std.data.MasterStdDataVO;
import com.ioiox.dei.core.orm.mybatis.model.std.data.SlaveStdDataVO;
import com.ioiox.dei.core.orm.mybatis.model.std.data.UpdatableObj;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;

public abstract class BaseDeiMasterStdDataSvc<
        T extends MasterStdDataVO,
        O extends UpdatableObj,
        E extends BaseDeiEntity> {

    protected void assembleCommonAttrsOnInsert(final BaseDeiEntity newEntity, final String createdBy, final Long createdTime) {
        newEntity.setVersionNum(BaseDeiEntity.INIT_VERSION_NUM);
        if (StringUtils.isBlank(createdBy)) {
            newEntity.setCreatedBy(DeiGlobalConstant.DEI_SYS_PRJ_DUCS);
        } else {
            newEntity.setCreatedBy(createdBy);
        }

        final Date lastUpdatedTime;
        if (Objects.isNull(createdTime)) {
            lastUpdatedTime = new Date(System.currentTimeMillis());
        } else {
            lastUpdatedTime = new Date(createdTime);
        }
        newEntity.setCreatedTime(lastUpdatedTime);
        newEntity.setUpdatedTime(lastUpdatedTime);
    }

    protected void assembleCommonAttrsOnInsert(final BaseDeiEntity newEntity, final MasterStdDataVO stdVO) {
        assembleCommonAttrsOnInsert(newEntity, stdVO.getCreatedBy(), stdVO.getCreatedTime());
    }

    protected void assembleCommonAttrsOnUpdate(final BaseDeiEntity example,
                                               final SlaveStdDataVO existingStdVO,
                                               final String updatedBy,
                                               final Long updatedTime) {
        example.setSid(existingStdVO.getId());
        example.setVersionNum(existingStdVO.getVersionNum());

        if (StringUtils.isBlank(example.getUpdatedBy())) {
            if (StringUtils.isBlank(updatedBy)) {
                example.setUpdatedBy(DeiGlobalConstant.DEI_SYS_PRJ_DUCS);
            } else {
                example.setUpdatedBy(updatedBy);
            }
        }
        if (Objects.isNull(example.getUpdatedTime())) {
            if (Objects.isNull(updatedTime)) {
                example.setUpdatedTime(new Date(System.currentTimeMillis()));
            } else {
                example.setUpdatedTime(new Date(updatedTime));
            }
        }
    }

    protected void assembleCommonAttrsOnUpdate(final BaseDeiEntity example, final SlaveStdDataVO existingStdVO, final MasterStdDataVO stdVO) {
        assembleCommonAttrsOnUpdate(example, existingStdVO, stdVO.getUpdatedBy(), stdVO.getUpdatedTime());
    }

    public abstract E toNewEntity(final T stdVO);

    public abstract E toUpdatableObj(final O updatableVO);

    protected void assembleCommonUpdatableAttrs(final BaseDeiEntity example, final UpdatableObj updatableObj) {
        if (Objects.nonNull(updatableObj.getLastModifiedTime())) {
            example.setUpdatedTime(updatableObj.getLastModifiedTime());
        }
    }
}
