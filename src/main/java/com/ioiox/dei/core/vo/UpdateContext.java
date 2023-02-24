package com.ioiox.dei.core.vo;

public abstract class UpdateContext<T extends UpdatableVO> {
    private boolean needUpdate;
    private T updatableObj;

    public boolean isNeedUpdate() {
        return needUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        this.needUpdate = needUpdate;
    }

    public T getUpdatableObj() {
        return updatableObj;
    }

    public void setUpdatableObj(T updatableObj) {
        this.updatableObj = updatableObj;
    }
}
