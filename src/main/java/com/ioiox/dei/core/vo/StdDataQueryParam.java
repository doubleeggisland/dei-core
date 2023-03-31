package com.ioiox.dei.core.vo;

import com.ioiox.dei.core.utils.DeiCollectionUtil;
import org.apache.commons.lang3.StringUtils;

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
        final QueryConditionsHolder conditionsHolder = new QueryConditionsHolder();
        if (DeiCollectionUtil.isNotEmpty(pks)) {
            if (pks.size() > 1) {
                conditionsHolder.addQueryCondition(QueryCondition.PARAM_NAME_PKS, pks);
            } else {
                conditionsHolder.addQueryCondition(QueryCondition.PARAM_NAME_PK, pks.get(0));
            }
        }
        if (Objects.nonNull(pageNo) && Objects.nonNull(pageSize)) {
            conditionsHolder.addQueryCondition(QueryCondition.PARAM_NAME_OFFSET, (pageNo - 1) * pageSize);
            conditionsHolder.addQueryCondition(QueryCondition.PARAM_NAME_LIMIT, pageSize);
        }
        if (StringUtils.isNotBlank(orderByClause)) {
            conditionsHolder.addQueryCondition(QueryCondition.PARAM_NAME_ORDER_BY_CLAUSE, orderByClause);
        }
        return conditionsHolder.queryParams();
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
