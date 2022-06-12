package com.ddd.tutio.booking;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Obiekt wartości reprezentujący unikalny identyfikator rezerwacji {@link BookingTemplate}/{@link Booking}.
 */
public class BookingId implements Serializable {

    public UUID id;

    protected BookingId() {
    }

    public BookingId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId = (BookingId) o;
        return id.equals(bookingId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
