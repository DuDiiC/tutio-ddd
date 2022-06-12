package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRepository;

import java.util.UUID;

/**
 * Implementacja wzorca taktycznego <b>repozytorium</b> dla agregatu rezerwacji {@link Booking}.
 */
public interface BookingRepository extends AggregateRepository<BookingId, Booking> {

    @Override
    default BookingId generateNext() {
        return new BookingId(UUID.randomUUID());
    }
}
