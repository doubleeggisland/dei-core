package com.ioiox.dei.core.vo;

import java.util.List;

public abstract class StdDataQueryParamBuilder<T extends StdDataQueryParam> {
    private List<Long> pks;
    private Integer pageNo;
    private Integer pageSize;
    private String orderByClause;

    public StdDataQueryParamBuilder<T> pks(final List<Long> pks) {
        this.pks = pks;
        return this;
    }
    public StdDataQueryParamBuilder<T> pageNo(final Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }
    public StdDataQueryParamBuilder<T> pageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
    public StdDataQueryParamBuilder<T> orderByClause(final String orderByClause) {
        this.orderByClause = orderByClause;
        return this;
    }

    public List<Long> pks() {
        return pks;
    }

    public Integer pageNo() {
        return pageNo;
    }

    public Integer pageSize() {
        return pageSize;
    }

    public String orderByClause() {
        return orderByClause;
    }

    public abstract T build();
}
