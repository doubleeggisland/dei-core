package com.ioiox.dei.core.vo;

import java.util.List;

public abstract class StdDataQueryCfgBuilder<T extends StdDataQueryCfg> {
    private List<String> showColumns;

    public StdDataQueryCfgBuilder<T> showColumns(final List<String> showColumns) {
        this.showColumns = showColumns;
        return this;
    }
    public List<String> showColumns() {
        return showColumns;
    }

    public abstract T build();
}
