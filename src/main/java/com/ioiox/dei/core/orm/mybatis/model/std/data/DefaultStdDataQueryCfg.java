package com.ioiox.dei.core.orm.mybatis.model.std.data;

public class DefaultStdDataQueryCfg extends StdDataQueryCfg {

    public DefaultStdDataQueryCfg() {

    }

    private DefaultStdDataQueryCfg(final Builder builder) {
        super(builder);
    }

    public static class Builder
            extends StdDataQueryCfgBuilder<DefaultStdDataQueryCfg> {

        @Override
        public DefaultStdDataQueryCfg build() {
            return new DefaultStdDataQueryCfg(this);
        }
    }
}
