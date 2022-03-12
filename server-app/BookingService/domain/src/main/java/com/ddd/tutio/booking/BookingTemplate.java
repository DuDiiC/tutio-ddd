package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

class BookingTemplate implements AggregateRoot<BookingId> {

    private final BookingId bookingId;

    // other aggregates
    final PupilId pupilId;
    final CourseId courseId;

    public BookingTemplate(BookingId bookingId, CourseId courseId, PupilId pupilId) {
        this.bookingId = bookingId;
        this.courseId = courseId;
        this.pupilId = pupilId;
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    public Booking toBooking() {
        return new Booking(this);
    }
}
