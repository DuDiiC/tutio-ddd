package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.time.Instant;

class BookingTemplate implements AggregateRoot<BookingId> {

    private final BookingId bookingId;
    final LessonPrice lessonPrice;
    final PupilId pupilId;
    final CourseId courseId;

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

    public Booking toBooking(Instant meetingStartTime, Instant meetingEndTime) {
        return new Booking(this, meetingStartTime, meetingEndTime);
    }
}
