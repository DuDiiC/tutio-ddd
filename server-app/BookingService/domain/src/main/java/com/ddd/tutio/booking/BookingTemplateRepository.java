package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRepository;

import java.util.UUID;

public interface BookingTemplateRepository extends AggregateRepository<BookingId, BookingTemplate> {

    @Override
    default BookingId generateNext() {
        return new BookingId(UUID.randomUUID());
    }
}
