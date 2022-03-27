package com.ddd.tutio.booking.database;

import com.ddd.tutio.booking.BookingId;
import com.ddd.tutio.booking.BookingTemplate;
import com.ddd.tutio.booking.BookingTemplateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
public class PostgresBookingTemplateRepository implements BookingTemplateRepository {

    private final JpaBookingTemplateRepository jpaBookingTemplateRepository;

    public PostgresBookingTemplateRepository(JpaBookingTemplateRepository jpaBookingTemplateRepository) {
        this.jpaBookingTemplateRepository = jpaBookingTemplateRepository;
    }

    @Override
    public BookingTemplate getById(BookingId bookingId) {
        return jpaBookingTemplateRepository.findById(bookingId.id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void add(BookingTemplate bookingTemplate) {

    }

    @Override
    public void remove(BookingTemplate bookingTemplate) {

    }
}
