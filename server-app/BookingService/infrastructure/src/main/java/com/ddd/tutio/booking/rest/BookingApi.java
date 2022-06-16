package com.ddd.tutio.booking.rest;

import com.ddd.tutio.booking.Booking;
import com.ddd.tutio.booking.BookingId;
import com.ddd.tutio.booking.BookingTemplate;
import com.ddd.tutio.booking.database.PostgresBookingRepository;
import com.ddd.tutio.booking.database.PostgresBookingTemplateRepository;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.booking.rabbitmq.producer.RabbitEventsProducer;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RestController
public class BookingApi {

    private final RabbitEventsProducer rabbitEventsProducer;
    private final PostgresBookingRepository bookingRepository;
    private final PostgresBookingTemplateRepository bookingTemplateRepository;

    public BookingApi(RabbitEventsProducer rabbitEventsProducer, PostgresBookingRepository bookingRepository,
                      PostgresBookingTemplateRepository bookingTemplateRepository) {
        this.rabbitEventsProducer = rabbitEventsProducer;
        this.bookingRepository = bookingRepository;
        this.bookingTemplateRepository = bookingTemplateRepository;
    }

    @GetMapping("/booking-process-started")
    public void createBookingProcessStartedEvent() {
        rabbitEventsProducer.publishEvent(new BookingProcessStarted(
                UUID.randomUUID(), Instant.now(),
                new CourseId(UUID.fromString("044c25c6-d53d-4a56-b7ae-1fe8681100c5")),
                new PupilId(UUID.fromString("bcc1e6c1-fe3c-408a-b667-af97abd01221")),
                new BigDecimal("30.00")
        ));
    }

    @GetMapping("/booking/{id}")
    public Booking getBookingById(@PathVariable UUID id) {
        return bookingRepository.getById(new BookingId(id));
    }

    @GetMapping("/booking-template/{id}")
    public BookingTemplate getBookingTemplate(@PathVariable UUID id) {
        return bookingTemplateRepository.getById(new BookingId(id));
    }
}
