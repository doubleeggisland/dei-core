package com.ioiox.dei.core.vo;

import java.util.Date;

public abstract class UpdatableObjAnalyser<
        M extends MasterStdDataVO,
        S extends SlaveStdDataVO,
        U extends UpdatableVO,
        C extends UpdateContext<U>> {

    public abstract C analyseUpdatedAttrs(final M stdVO, final S existingStdVO);
    protected void analyseUpdatedAttrs(final M stdVO, final S existingStdVO, final C updateContext) {

    }
    public void updateLastModifiedTime(final C updateContext) {
        updateContext.getUpdatableObj().setLastModifiedTime(new Date(System.currentTimeMillis()));
    }
}
