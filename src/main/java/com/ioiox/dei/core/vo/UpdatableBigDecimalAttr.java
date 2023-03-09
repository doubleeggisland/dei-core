package com.ioiox.dei.core.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class UpdatableBigDecimalAttr
        extends UpdatableAttr<BigDecimal> {

    protected String formatOldVal() {
        final double oldVal = Objects.isNull(getOldVal()) ? 0.00 : getOldVal().setScale(2, RoundingMode.HALF_UP).doubleValue();
        return String.valueOf(oldVal);
    }

    protected String formatNewVal() {
        final double newVal = Objects.isNull(getNewVal()) ? 0.00 : getNewVal().setScale(2, RoundingMode.HALF_UP).doubleValue();
        return String.valueOf(newVal);
    }
}
