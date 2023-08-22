package com.ioiox.dei.core.constant;

import java.util.Objects;

/**
 * 系统资源权限级别
 */
public enum DeiResPrivilegeLvl {
    SHARED("shared", 10, "共享"),
    IMPORTANT("important", 35, "重要"),
    SECRET("secret", 70, "机密"),
    TOP_SECRET("top-secret", 100, "绝密"),
    NONE("none", 0, "无"),
    ;

    /**
     * 编码
     */
    private final String code;
    /**
     * 权重指数
     */
    private final int weightIdx;
    /**
     * 描述
     */
    private final String desc;

    DeiResPrivilegeLvl(final String code, final int weightIdx, final String desc) {
        this.code = code;
        this.weightIdx = weightIdx;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public int getWeightIdx() {
        return weightIdx;
    }

    public String getDesc() {
        return desc;
    }

    public DeiResPrivilegeLvl getByCode(final String code) {
        for (final DeiResPrivilegeLvl sysResPrivilegeLvl : values()) {
            if (Objects.equals(sysResPrivilegeLvl.code, code)) {
                return sysResPrivilegeLvl;
            }
        }
        return NONE;
    }
}
