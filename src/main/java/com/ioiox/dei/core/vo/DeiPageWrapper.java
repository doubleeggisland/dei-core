package com.ioiox.dei.core.vo;

import java.util.Objects;

public class DeiPageWrapper<T> {
    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;
    private T result;
    private Integer pageSize;
    private Integer pageNo;
    private Integer totalCount;

    public DeiPageWrapper() {
    }

    public DeiPageWrapper(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public DeiPageWrapper(Integer pageNo, Integer pageSize, Integer totalCount) {
        this(pageNo, pageSize);
        this.totalCount = totalCount;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        if (!Objects.isNull(this.totalCount) && this.totalCount > 0) {
            return this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        } else {
            return 0;
        }
    }
}
