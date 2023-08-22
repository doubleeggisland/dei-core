package com.ioiox.dei.core.orm.mybatis.model.std.data;

import com.ioiox.dei.core.constant.DeiGlobalConstant;

public class UpdatableAttr<T> {
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 更新前的值
     */
    private T oldVal;
    /**
     * 更新后的值
     */
    private T newVal;

    private boolean sensitive;

    public UpdatableAttr() {

    }

    public UpdatableAttr(final String attrName, final T oldVal, final T newVal) {
        this(attrName, oldVal, newVal, false);
    }

    public UpdatableAttr(final String attrName, final T oldVal, final T newVal, final boolean sensitive) {
        this.attrName  = attrName;
        this.oldVal = oldVal;
        this.newVal = newVal;
        this.sensitive = sensitive;
    }

    public String getAttrName() {
        return attrName;
    }

    public T getOldVal() {
        return oldVal;
    }

    public T getNewVal() {
        return newVal;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    protected String formatSensitiveVal() {
        return DeiGlobalConstant.SENSITIVE_INFO_PLACEHOLDER;
    }

    protected String formatNonsensitiveOldVal() {
        return String.valueOf(oldVal);
    }

    protected String formatNonsensitiveNewVal() {
        return String.valueOf(newVal);
    }

    protected String formatOldVal() {
        if (sensitive) {
            return formatSensitiveVal();
        } else {
            return formatNonsensitiveOldVal();
        }
    }

    protected String formatNewVal() {
        if (sensitive) {
            return formatSensitiveVal();
        } else {
            return formatNonsensitiveNewVal();
        }
    }

    @Override
    public String toString() {
        return String.format("%s => %s", formatOldVal(), formatNewVal());
    }
}
