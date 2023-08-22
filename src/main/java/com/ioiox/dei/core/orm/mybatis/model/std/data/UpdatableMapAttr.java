package com.ioiox.dei.core.orm.mybatis.model.std.data;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import com.ioiox.dei.core.utils.JsonUtil;

import java.util.Map;
import java.util.Objects;

public class UpdatableMapAttr<K, V>
        extends UpdatableAttr<Map<K, V>> {

    public UpdatableMapAttr(final String attrName, final Map<K, V> oldVal, final Map<K, V> newVal) {
        this(attrName, oldVal, newVal, false);
    }

    public UpdatableMapAttr(final String attrName, final Map<K, V> oldVal, final Map<K, V> newVal, final boolean sensitive) {
        super(attrName, oldVal, newVal, sensitive);
    }

    @Override
    protected String formatNonsensitiveOldVal() {
        if (Objects.isNull(getOldVal())) {
            return DeiGlobalConstant.ZERO_LENGTH_STR;
        }
        try {
            return JsonUtil.toJsonStr(getOldVal());
        } catch (Exception e) {
            return DeiGlobalConstant.ZERO_LENGTH_STR;
        }
    }

    @Override
    protected String formatNonsensitiveNewVal() {
        if (Objects.isNull(getNewVal())) {
            return DeiGlobalConstant.ZERO_LENGTH_STR;
        }
        try {
            return JsonUtil.toJsonStr(getNewVal());
        } catch (Exception e) {
            return DeiGlobalConstant.ZERO_LENGTH_STR;
        }
    }
}
