package com.ioiox.dei.core.beans;

public abstract class BaseDeiRelationshipEntity<F, S>
        extends BaseDeiEntity {

    public abstract RelationshipItem<F, S> toRelationshipItem();
}
