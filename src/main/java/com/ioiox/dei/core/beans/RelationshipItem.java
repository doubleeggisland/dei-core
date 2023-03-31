package com.ioiox.dei.core.beans;

public class RelationshipItem<F, S> {
    private F uniqueKeyOf1st;
    private S uniqueKeyOf2nd;

    public RelationshipItem() {

    }

    public RelationshipItem(final F uniqueKeyOf1st, final S uniqueKeyOf2nd) {
        this.uniqueKeyOf1st = uniqueKeyOf1st;
        this.uniqueKeyOf2nd = uniqueKeyOf2nd;
    }

    public F getUniqueKeyOf1st() {
        return uniqueKeyOf1st;
    }

    public void setUniqueKeyOf1st(final F uniqueKeyOf1st) {
        this.uniqueKeyOf1st = uniqueKeyOf1st;
    }

    public S getUniqueKeyOf2nd() {
        return uniqueKeyOf2nd;
    }

    public void setUniqueKeyOf2nd(final S uniqueKeyOf2nd) {
        this.uniqueKeyOf2nd = uniqueKeyOf2nd;
    }
}
