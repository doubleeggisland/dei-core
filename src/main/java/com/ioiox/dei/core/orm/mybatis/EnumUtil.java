package com.ioiox.dei.core.orm.mybatis;

import com.ioiox.dei.core.constant.BaseDeiEnum;

public class EnumUtil {
    public static <T extends Enum<?> & BaseDeiEnum> T codeOf(Class<T> enumClass, String code) {
        T [] enumConstants = enumClass.getEnumConstants();
        for (T enumConstant : enumConstants) {
            if (enumConstant.getCode().equals(code)) {
                return enumConstant;
            }
        }
        return null;
    }
}
