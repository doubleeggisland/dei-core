package com.ioiox.dei.core.orm.mybatis.model.std.data;

import com.ioiox.dei.core.utils.DeiCollectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class StdDataDelParam {
    private List<Long> pks;

    public StdDataDelParam() {}

    public StdDataDelParam(StdDataDelParamBuilder<? extends StdDataDelParam> builder) {
        pks = builder.pks();
    }

    public Map<String, Object> deleteParams() {
        final Map<String, Object> deleteParams = new HashMap<>(5);
        if (DeiCollectionUtil.isNotEmpty(pks)) {
            if (pks.size() > 1) {
                deleteParams.put("sids", pks);
            } else {
                deleteParams.put("sid", pks.get(0));
            }
        }
        return deleteParams;
    }

    public List<Long> getPks() {
        return pks;
    }

    public void setPks(List<Long> pks) {
        this.pks = pks;
    }
}
