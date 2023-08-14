package com.ioiox.dei.core.vo;

import java.util.LinkedList;
import java.util.List;

public abstract class StdDataQueryCfgBuilder<T extends StdDataQueryCfg> {
    private final List<String> showColumns = new LinkedList<>();

    public StdDataQueryCfgBuilder<T> showColumns(final List<String> showColumns) {
        this.showColumns.addAll(showColumns);
        return this;
    }
    public List<String> showColumns() {
        return showColumns;
    }

    public abstract T build();
}
