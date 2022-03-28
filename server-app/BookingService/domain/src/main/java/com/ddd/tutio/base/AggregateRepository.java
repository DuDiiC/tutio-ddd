package com.ddd.tutio.base;

public interface AggregateRepository<ID, Aggregate> extends ReadOnlyAggregateRepository<ID, Aggregate> {

    ID generateNext();

    void add(Aggregate aggregate);

    void remove(Aggregate aggregate);
}
