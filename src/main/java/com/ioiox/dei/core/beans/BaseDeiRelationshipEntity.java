package com.ioiox.dei.core.beans;

import com.ioiox.dei.core.orm.mybatis.model.RelationshipItem;

public abstract class BaseDeiRelationshipEntity<F, S>
        extends BaseDeiEntity {

    public abstract RelationshipItem<F, S> toRelationshipItem();
}
