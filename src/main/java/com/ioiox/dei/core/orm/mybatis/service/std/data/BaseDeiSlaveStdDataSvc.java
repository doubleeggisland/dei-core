package com.ioiox.dei.core.orm.mybatis.service.std.data;

import com.ioiox.dei.core.beans.BaseDeiEntity;
import com.ioiox.dei.core.utils.DeiCollectionUtil;
import com.ioiox.dei.core.orm.mybatis.model.std.data.SlaveStdDataVO;
import com.ioiox.dei.core.orm.mybatis.model.std.data.StdDataQueryCfg;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public abstract class BaseDeiSlaveStdDataSvc<T extends SlaveStdDataVO, E extends BaseDeiEntity> {

    protected void addShowColumnsIfNeeded(final StdDataQueryCfg queryCfg, final List<String> shownColumns) {
        if (DeiCollectionUtil.isEmpty(shownColumns)) {
            return;
        }
        if (Objects.isNull(queryCfg) || Objects.isNull(queryCfg.getShowColumns())) {
            return;
        }
        queryCfg.getShowColumns().addAll(shownColumns);
    }

    protected void assembleCommonAttrs(final SlaveStdDataVO stdVO, final BaseDeiEntity entity) {
        stdVO.setId(entity.getSid());
        stdVO.setLastModifiedBy(StringUtils.isNotBlank(entity.getUpdatedBy()) ? entity.getUpdatedBy() : entity.getCreatedBy());
        stdVO.setVersionNum(entity.getVersionNum());
        if (Objects.nonNull(entity.getUpdatedTime())) {
            stdVO.setLastModifiedTime(entity.getUpdatedTime().getTime());
        } else if (Objects.nonNull(entity.getCreatedTime())) {
            stdVO.setLastModifiedTime(entity.getCreatedTime().getTime());
        }
    }

    public abstract T transferToStdDataVO(final E entity);
}
