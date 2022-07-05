package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.BookingId;

import java.time.Instant;
import java.util.UUID;

public class TimeForBookingExpired extends DomainEvent {

    public final BookingId bookingId;

    public TimeForBookingExpired(UUID eventId, Instant createdOn, BookingId bookingId) {
        super(eventId, createdOn);
        this.bookingId = bookingId;
    }
}
