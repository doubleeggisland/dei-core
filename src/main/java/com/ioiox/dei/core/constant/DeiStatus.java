package com.ioiox.dei.core.constant;

public enum DeiStatus implements BaseDeiEnum {
    ENABLE("enable", "启用"),
    DISABLE("disable", "禁用"),
    DELETE("delete", "删除"),
    ;

    private final String code;
    private final String desc;

    DeiStatus(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
