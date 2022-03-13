package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.time.Instant;

class Booking implements AggregateRoot<BookingId> {

    private final BookingId bookingId;

    private final MeetingDuration meetingDuration;
    private final LessonPrice lessonPrice;

    // other aggregates
    final CourseId courseId;
    final PupilId pupilId;

    Booking(BookingTemplate template, Instant meetingStartTime, Instant meetingEndTime) {
        this.bookingId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
        this.meetingDuration = new MeetingDuration(meetingStartTime, meetingEndTime);
        this.lessonPrice = template.lessonPrice;
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }
}
