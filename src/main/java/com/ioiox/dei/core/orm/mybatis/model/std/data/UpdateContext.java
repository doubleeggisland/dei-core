package com.ioiox.dei.core.orm.mybatis.model.std.data;

public abstract class UpdateContext<T extends UpdatableObj> {

    private T updatableObj;

    public T getUpdatableObj() {
        return updatableObj;
    }

    public void setUpdatableObj(T updatableObj) {
        this.updatableObj = updatableObj;
    }
}
