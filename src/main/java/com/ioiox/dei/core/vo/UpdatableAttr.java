package com.ioiox.dei.core.vo;

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

    public UpdatableAttr() {

    }

    public UpdatableAttr(final String attrName, final T oldVal, final T newVal) {
        this.attrName  = attrName;
        this.oldVal = oldVal;
        this.newVal = newVal;
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

    protected String formatOldVal() {
        return String.valueOf(oldVal);
    }

    protected String formatNewVal() {
        return String.valueOf(newVal);
    }

    @Override
    public String toString() {
        return String.format("%s: %s => %s", attrName, formatOldVal(), formatNewVal());
    }
}
