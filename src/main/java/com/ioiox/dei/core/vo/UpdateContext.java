package com.ioiox.dei.core.vo;

public abstract class UpdateContext<T extends UpdatableVO> {
    private T updatableObj;

    public T getUpdatableObj() {
        return updatableObj;
    }

    public void setUpdatableObj(T updatableObj) {
        this.updatableObj = updatableObj;
    }
}
