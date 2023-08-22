package com.ioiox.dei.core.orm.mybatis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelationshipItemsHolder<F, S> {
    private final List<RelationshipItem<F, S>> relationshipItems;

    public RelationshipItemsHolder(final int size) {
        relationshipItems = new ArrayList<>(size);
    }

    public Map<F, List<S>> groupBy1st() {
        return relationshipItems.stream()
                .collect(Collectors.groupingBy(RelationshipItem::getUniqueKeyOf1st, Collectors.mapping(RelationshipItem::getUniqueKeyOf2nd, Collectors.toList())));
    }

    public Map<S, List<F>> groupBy2nd() {
        return relationshipItems.stream()
                .collect(Collectors.groupingBy(RelationshipItem::getUniqueKeyOf2nd, Collectors.mapping(RelationshipItem::getUniqueKeyOf1st, Collectors.toList())));
    }

    public void addRelationshipItem(final RelationshipItem<F, S> item) {
        relationshipItems.add(item);
    }

    public List<RelationshipItem<F, S>> getRelationshipItems() {
        return relationshipItems;
    }
}
