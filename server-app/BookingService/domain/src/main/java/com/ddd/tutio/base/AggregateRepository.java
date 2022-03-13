package com.ddd.tutio.base;

public interface AggregateRepository<ID, Aggregate> {

    ID generateNext();

    Aggregate getById(ID id);

    void add(Aggregate aggregate);

    void remove(Aggregate aggregate);
}
