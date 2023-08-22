package com.ioiox.dei.core.orm.mybatis.model.std.data;

public abstract class UpdatableObjAnalyser<
        M extends MasterStdDataVO,
        S extends SlaveStdDataVO,
        U extends UpdatableObj,
        C extends UpdateContext<U>> {

    public abstract C analyseUpdatedAttrs(final M stdVO, final S existingStdVO);
    protected void analyseUpdatedAttrs(final M stdVO, final S existingStdVO, final C updateContext) {

    }
}
