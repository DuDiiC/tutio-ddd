package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRepository;

import java.util.UUID;

/**
 * Implementacja wzorca taktycznego <b>repozytorium</b> dla agregatu szablonu rezerwacji {@link BookingTemplate}.
 */
public interface BookingTemplateRepository extends AggregateRepository<BookingId, BookingTemplate> {

    @Override
    default BookingId generateNext() {
        return new BookingId(UUID.randomUUID());
    }
}
