package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.BookingId;

import java.time.Instant;
import java.util.UUID;

/**
 * <b>Zdarzenie domenowe</b> informujące o prośbie zaplanowania rezerwacji.
 */
public class PlanBookingRequested extends DomainEvent {

    public final BookingId bookingId;
    public final Instant startTime;
    public final Instant endTime;

    public PlanBookingRequested(UUID eventId, Instant createdOn, BookingId bookingId, Instant startTime, Instant endTime) {
        super(eventId, createdOn);
        this.bookingId = bookingId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
