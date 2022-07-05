package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.event.BookingCountdownStarted;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.booking.event.PlanBookingRequested;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BookingTemplate implements AggregateRoot<BookingId> {

    private List<DomainEvent> events = new ArrayList<>();

    private BookingId bookingId;

    CourseId courseId;

    PupilId pupilId;

    LessonPrice lessonPrice;

    protected BookingTemplate() {
    }

    public BookingTemplate(BookingId bookingId, BookingProcessStarted event) {
        this.bookingId = bookingId;
        this.courseId = event.courseId;
        this.pupilId = event.pupilId;
        this.lessonPrice = new LessonPrice(event.lessonPrice, Currency.PLN);

        events.add(new BookingCountdownStarted(UUID.randomUUID(), Instant.now(), bookingId));
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    @Override
    public List<DomainEvent> events() {
        return Collections.unmodifiableList(this.events);
    }

    public Booking toBooking(PlanBookingRequested event) {
        return new Booking(this, event);
    }
}
