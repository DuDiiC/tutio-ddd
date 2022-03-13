package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.BigDecimal;
import java.time.Instant;

class BookingTemplate implements AggregateRoot<BookingId> {

    private final BookingId bookingId;

    final LessonPrice lessonPrice;

    // other aggregates
    final PupilId pupilId;
    final CourseId courseId;

    public BookingTemplate(BookingId bookingId, CourseId courseId, PupilId pupilId, BigDecimal lessonPrice) {
        this.bookingId = bookingId;
        this.courseId = courseId;
        this.pupilId = pupilId;
        // other currencies in the future
        this.lessonPrice = new LessonPrice(lessonPrice, Currency.PLN);
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    public Booking toBooking(Instant meetingStartTime, Instant meetingEndTime) {
        return new Booking(this, meetingStartTime, meetingEndTime);
    }
}
