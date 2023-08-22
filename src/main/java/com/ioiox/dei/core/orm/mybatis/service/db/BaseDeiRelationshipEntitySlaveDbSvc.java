package com.ioiox.dei.core.orm.mybatis.service.db;

import com.ioiox.dei.core.beans.BaseDeiRelationshipEntity;
import com.ioiox.dei.core.orm.mybatis.model.RelationshipItemsHolder;
import com.ioiox.dei.core.orm.mybatis.mapper.AbstractDeiSlaveMapper;
import com.ioiox.dei.core.utils.DeiCollectionUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class BaseDeiRelationshipEntitySlaveDbSvc<
        F,
        S,
        T extends BaseDeiRelationshipEntity<F, S>,
        M extends AbstractDeiSlaveMapper<T>>
        extends BaseDeiSlaveDbService<T, M> {

    protected Map<F, List<S>> getUniqueKeysGroupedBy1st(final Map<String, Object> queryParams,
                                                        final List<String> showColumns) {
        final RelationshipItemsHolder<F, S> itemsHolder = getRelationshipItemsByParams(queryParams, showColumns);
        return Objects.isNull(itemsHolder) ? Collections.emptyMap() : itemsHolder.groupBy1st();
    }

    protected Map<S, List<F>> getUniqueKeysGroupedBy2nd(final Map<String, Object> queryParams,
                                                        final List<String> showColumns) {
        final RelationshipItemsHolder<F, S> itemsHolder = getRelationshipItemsByParams(queryParams, showColumns);
        return Objects.isNull(itemsHolder) ? Collections.emptyMap() : itemsHolder.groupBy2nd();
    }

    protected RelationshipItemsHolder<F, S> getRelationshipItemsByParams(final Map<String, Object> queryParams, final List<String> showColumns) {
        final List<T> relationships =
                findByParams(queryParams, showColumns);
        if (DeiCollectionUtil.isEmpty(relationships)) {
            return null;
        }
        final RelationshipItemsHolder<F, S> itemsHolder = new RelationshipItemsHolder<>(relationships.size());
        relationships.forEach(relationship -> itemsHolder.addRelationshipItem(relationship.toRelationshipItem()));
        return itemsHolder;
    }
}
