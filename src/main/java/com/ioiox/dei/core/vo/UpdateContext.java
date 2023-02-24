package com.ioiox.dei.core.vo;

public abstract class UpdateContext<T extends UpdatableVO> {
    private boolean needUpdate;
    private T updatableObj;
}
