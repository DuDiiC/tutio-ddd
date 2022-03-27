package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.booking.event.PlanBookingRequested;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

public class BookingTemplate implements AggregateRoot<BookingId> {

    private BookingId bookingId;
    // other aggregates
    PupilId pupilId;
    CourseId courseId;

    LessonPrice lessonPrice;

    protected BookingTemplate() {
    }

    public BookingTemplate(BookingId bookingId, BookingProcessStarted event) {
        this.bookingId = bookingId;
        this.courseId = event.courseId;
        this.pupilId = event.pupilId;
        this.lessonPrice = new LessonPrice(event.lessonPrice, Currency.PLN);
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    public Booking toBooking(PlanBookingRequested event) {
        return new Booking(this, event);
    }
}
