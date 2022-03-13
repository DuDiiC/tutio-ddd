package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.RoundingMode;
import java.time.Instant;

class Booking implements AggregateRoot<BookingId> {

    private final BookingId bookingId;

    private final MeetingDuration meetingDuration;
    private final LessonPrice lessonPrice;
    private BookingStatus status;

    // other aggregates
    final CourseId courseId;
    final PupilId pupilId;

    Booking(BookingTemplate template, Instant meetingStartTime, Instant meetingEndTime) {
        this.bookingId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
        this.meetingDuration = new MeetingDuration(meetingStartTime, meetingEndTime);
        this.lessonPrice = template.lessonPrice;
        this.status = BookingStatus.PLANNED;
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    public BookingStatus status() {
        return this.status;
    }

    public MeetingCost calculateMeetingCost() {
        var calculatedCost = lessonPrice.price
                .multiply(this.meetingDuration.partOfHour())
                .setScale(2, RoundingMode.HALF_UP);
        return new MeetingCost(calculatedCost, this.lessonPrice.currency);
    }

    public void approve() {
        // TODO - publish event
        if (bookingCanBeApproved()) {
            this.status = BookingStatus.APPROVED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void cancel() {
        // TODO - publish event
        if (bookingCanBeCanceled()) {
            this.status = BookingStatus.CANCELED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void accept() {
        // TODO - publish event
        if (bookingCanBeAccepted()) {
            this.status = BookingStatus.ACCEPTED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private boolean bookingCanBeApproved() {
        return this.status.equals(BookingStatus.PLANNED);
    }

    private boolean bookingCanBeCanceled() {
        return this.status.equals(BookingStatus.PLANNED);
    }

    private boolean bookingCanBeAccepted() {
        return this.status.equals(BookingStatus.APPROVED);
    }
}
