package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.BookingId;

import java.time.Instant;
import java.util.UUID;

public class BookingCancelled extends DomainEvent {

    public final BookingId bookingId;
    public final String cancellationReason;

    public BookingCancelled(UUID eventId, Instant createdOn, BookingId bookingId, String cancellationReason) {
        super(eventId, createdOn);
        this.bookingId = bookingId;
        this.cancellationReason = cancellationReason;
    }
}
