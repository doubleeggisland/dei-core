package com.ioiox.dei.core.orm.mybatis.model.std.data;

import java.util.List;

public abstract class StdDataDelParamBuilder<T extends StdDataDelParam> {
    private List<Long> pks;

    public StdDataDelParamBuilder<T> pks(final List<Long> pks) {
        this.pks = pks;
        return this;
    }
    public List<Long> pks() {
        return pks;
    }

    public abstract T build();
}
