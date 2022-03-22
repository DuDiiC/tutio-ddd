package com.ddd.tutio.booking.port.event.producer;

import com.ddd.tutio.base.DomainEvent;

import java.util.Collection;
import java.util.Comparator;

public interface BookingEventsProducer {

    void publishEvent(DomainEvent event);

    default void publishEvents(Collection<DomainEvent> events) {
        events.stream()
                .sorted(Comparator.comparing(event -> event.createdOn))
                .forEach(this::publishEvent);
    }
}
