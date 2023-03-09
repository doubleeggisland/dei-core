package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.utils.DateUtil;

import java.util.Date;
import java.util.Objects;

public class UpdatableTimestampAttr
        extends UpdatableAttr<Date> {

    protected String formatOldVal() {
        return Objects.isNull(getOldVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getOldVal(), DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    protected String formatNewVal() {
        return Objects.isNull(getNewVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getNewVal(), DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
    }
}
