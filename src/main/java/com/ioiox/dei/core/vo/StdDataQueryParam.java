package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.utils.DeiCollectionUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class StdDataQueryParam {
    private List<Long> pks;
    private Integer pageNo;
    private Integer pageSize;
    private String orderByClause;

    public StdDataQueryParam() {

    }

    public StdDataQueryParam(final StdDataQueryParamBuilder<? extends StdDataQueryParam> builder) {
        pks = builder.pks();
        pageNo = builder.pageNo();
        pageSize = builder.pageSize();
        orderByClause = builder.orderByClause();
    }

    public Map<String, Object> queryParams() {
        final Map<String, Object> queryParams = new HashMap<>();
        if (DeiCollectionUtil.isNotEmpty(pks)) {
            if (pks.size() > 1) {
                queryParams.put("sids", pks);
            } else {
                queryParams.put("sid", pks.get(0));
            }
        }
        if (Objects.nonNull(pageNo) && Objects.nonNull(pageSize)) {
            queryParams.put("offset", (pageNo - 1) * pageSize);
            queryParams.put("limit", pageSize);
        }
        if (StringUtils.isNotBlank(orderByClause)) {
            queryParams.put("orderByClause", orderByClause);
        }
        return queryParams;
    }

    public List<Long> getPks() {
        return pks;
    }

    public void setPks(List<Long> pks) {
        this.pks = pks;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
