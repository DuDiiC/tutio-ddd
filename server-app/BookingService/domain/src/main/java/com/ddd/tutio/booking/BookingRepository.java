package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRepository;

import java.util.UUID;

public interface BookingRepository extends AggregateRepository<BookingId, Booking> {

    @Override
    default BookingId generateNext() {
        return new BookingId(UUID.randomUUID());
    }
}
