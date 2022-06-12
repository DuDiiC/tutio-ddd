package com.ddd.tutio.booking.port.event.producer;

import com.ddd.tutio.base.DomainEvent;

import java.util.Collection;
import java.util.Comparator;

/**
 * Interfejs zapewniający kontrakt związany z publikowaniem zdarzeń domenowych.
 */
public interface BookingEventsProducer {

    /**
     * Publikuje zdarzenie domenowe w zdefiniowanym w warstwie infrastruktury magazynie trwałym.
     * @param event - zdarzenie, które ma zostać opublikowane
     */
    void publishEvent(DomainEvent event);

    /**
     * Publikuje kolekcję zdarzeń domenowych w zdefiniowanym w warstwie infrastruktury magazynie trwałym,
     * <b>z zachowaniem kolejności wystąpienia zdarzeń</b>.
     * @param events - zdarzenia, które mają zostać opublikowane
     */
    default void publishEvents(Collection<DomainEvent> events) {
        events.stream()
                .sorted(Comparator.comparing(event -> event.createdOn))
                .forEach(this::publishEvent);
    }
}
