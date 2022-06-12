package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.BookingId;

import java.time.Instant;
import java.util.UUID;

/**
 * <b>Zdarzenie domenowe</b> informujące, że rezerwacja została zaplanowana.
 */
public class BookingPlanned extends DomainEvent {

    public final BookingId bookingId;

    public BookingPlanned(UUID eventId, Instant createdOn, BookingId bookingId) {
        super(eventId, createdOn);
        this.bookingId = bookingId;
    }
}
