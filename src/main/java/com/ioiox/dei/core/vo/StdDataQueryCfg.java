package com.ioiox.dei.core.vo;

import java.util.List;

public abstract class StdDataQueryCfg {
    private List<String> showColumns;

    public StdDataQueryCfg() {

    }

    public StdDataQueryCfg(final StdDataQueryCfgBuilder<? extends StdDataQueryCfg> builder) {
        showColumns = builder.showColumns();
    }

    public List<String> getShowColumns() {
        return showColumns;
    }

    public void setShowColumns(List<String> showColumns) {
        this.showColumns = showColumns;
    }
}
