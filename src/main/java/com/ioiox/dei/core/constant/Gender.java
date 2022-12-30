package com.ioiox.dei.core.constant;

import com.ioiox.dei.core.beans.BaseDeiEnum;

public enum Gender implements BaseDeiEnum {
    MALE("male", "男"),
    FEMALE("female", "女"),
    UNKNOWN("unknown", "未知"),
    ;
    private final String code;
    private final String desc;

    Gender(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
