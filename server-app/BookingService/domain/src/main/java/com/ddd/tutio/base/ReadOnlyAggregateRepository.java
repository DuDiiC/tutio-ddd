package com.ddd.tutio.base;

public interface ReadOnlyAggregateRepository<ID, Aggregate> {

    Aggregate getById(ID id);

    boolean existsById(ID id);
}
