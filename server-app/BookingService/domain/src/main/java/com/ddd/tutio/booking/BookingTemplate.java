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

/**
 * Agregat szablonu rezerwacji. Powstaje w momencie rozpoczęcia przez ucznia procesu rezerwacji i nadania jej unikalnego identyfikatora jeszcze przed
 * zaplanowaniem.
 */
public class BookingTemplate implements AggregateRoot<BookingId> {

    private List<DomainEvent> events = new ArrayList<>();

    /**
     * Identyfikator rezerwacji.
     */
    private BookingId bookingId;

    /**
     * Identyfikator kursu związanego z rezerwacją.
     */
    CourseId courseId;

    /**
     * Indentyfikator ucznia dokonującego rezerwacji.
     */
    PupilId pupilId;

    /**
     * Cena lekcji w ramach rezerwacji.
     */
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

    /**
     * Na podstawie szablonu rezerwacji tworzy planowaną rezerwację {@link Booking}
     * @param event zdarzenie domenowe planowania rezerwacji
     */
    public Booking toBooking(PlanBookingRequested event) {
        return new Booking(this, event);
    }
}
