package com.ddd.tutio.base;

import java.util.List;

public interface AggregateRoot<ID> extends Entity<ID> {

    List<DomainEvent> events();
}
