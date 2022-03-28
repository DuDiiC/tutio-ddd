package com.ddd.tutio.booking.database;

import com.ddd.tutio.booking.Booking;
import com.ddd.tutio.booking.BookingId;
import com.ddd.tutio.booking.BookingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
public class PostgresBookingRepository implements BookingRepository {

    private final JpaBookingRepository jpaBookingRepository;

    public PostgresBookingRepository(JpaBookingRepository jpaBookingRepository) {
        this.jpaBookingRepository = jpaBookingRepository;
    }

    @Override
    public Booking getById(BookingId bookingId) {
        return jpaBookingRepository.findById(bookingId.id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean existsById(BookingId bookingId) {
        return false;
    }

    @Override
    public void add(Booking booking) {
        //TODO: IMPLEMENT
    }

    @Override
    public void remove(Booking booking) {
        //TODO: IMPLEMENT
    }
}
