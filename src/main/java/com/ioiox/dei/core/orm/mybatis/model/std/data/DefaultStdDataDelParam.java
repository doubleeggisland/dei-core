package com.ioiox.dei.core.orm.mybatis.model.std.data;

public class DefaultStdDataDelParam
        extends StdDataDelParam {

    public DefaultStdDataDelParam() {}

    private DefaultStdDataDelParam(final Builder builder) {
        super(builder);
    }

    public static class Builder
            extends StdDataDelParamBuilder<DefaultStdDataDelParam> {

        @Override
        public DefaultStdDataDelParam build() {
            return new DefaultStdDataDelParam(this);
        }
    }
}
