package com.ddd.tutio.base;

import java.util.List;

public interface AggregateRoot<T> extends Entity<T> {

    List<DomainEvent> events();
}
