package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.utils.DateUtil;

import java.sql.Time;
import java.util.Objects;

public class UpdatableTimeAttr
        extends UpdatableAttr<Time> {

    public UpdatableTimeAttr(final String attrName, final Time oldVal, final Time newVal) {
        this(attrName, oldVal, newVal, false);
    }

    public UpdatableTimeAttr(final String attrName, final Time oldVal, final Time newVal, final boolean sensitive) {
        super(attrName, oldVal, newVal, sensitive);
    }

    protected String formatNonsensitiveOldVal() {
        return Objects.isNull(getOldVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getOldVal(), DateUtil.PATTERN_HH_MM_SS);
    }

    protected String formatNonsensitiveNewVal() {
        return Objects.isNull(getNewVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getNewVal(), DateUtil.PATTERN_HH_MM_SS);
    }
}
