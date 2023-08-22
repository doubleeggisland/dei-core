package com.ioiox.dei.core.orm.mybatis.model.std.data;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.utils.DateUtil;

import java.util.Date;
import java.util.Objects;

public class UpdatableDateAttr
        extends UpdatableAttr<Date> {

    public UpdatableDateAttr() {

    }

    public UpdatableDateAttr(final String attrName, final Date oldVal, final Date newVal) {
        this(attrName, oldVal, newVal, false);
    }

    public UpdatableDateAttr(final String attrName, final Date oldVal, final Date newVal, final boolean sensitive) {
        super(attrName, oldVal, newVal, sensitive);
    }

    protected String formatNonsensitiveOldVal() {
        return Objects.isNull(getOldVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getOldVal(), DateUtil.PATTERN_YYYY_MM_DD);
    }

    protected String formatNonsensitiveNewVal() {
        return Objects.isNull(getNewVal()) ?
                DeiGlobalConstant.ZERO_LENGTH_STR : DateUtil.format(getNewVal(), DateUtil.PATTERN_YYYY_MM_DD);
    }
}
