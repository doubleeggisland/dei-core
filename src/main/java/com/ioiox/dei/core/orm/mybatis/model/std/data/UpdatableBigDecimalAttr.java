package com.ioiox.dei.core.orm.mybatis.model.std.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class UpdatableBigDecimalAttr
        extends UpdatableAttr<BigDecimal> {

    public UpdatableBigDecimalAttr(final String attrName, final BigDecimal oldVal, final BigDecimal newVal) {
        this(attrName, oldVal, newVal, false);
    }

    public UpdatableBigDecimalAttr(final String attrName, final BigDecimal oldVal, final BigDecimal newVal, final boolean sensitive) {
        super(attrName, oldVal, newVal, sensitive);
    }

    @Override
    protected String formatNonsensitiveOldVal() {
        final double oldVal = Objects.isNull(getOldVal()) ? 0.00 : getOldVal().setScale(2, RoundingMode.HALF_UP).doubleValue();
        return String.valueOf(oldVal);
    }

    @Override
    protected String formatNonsensitiveNewVal() {
        final double newVal = Objects.isNull(getNewVal()) ? 0.00 : getNewVal().setScale(2, RoundingMode.HALF_UP).doubleValue();
        return String.valueOf(newVal);
    }
}
