package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.booking.event.PlanBookingRequested;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.RoundingMode;

public class Booking implements AggregateRoot<BookingId> {

    // other aggregates
    final CourseId courseId;
    final PupilId pupilId;
    private final BookingId bookingId;
    private final MeetingDuration meetingDuration;
    private final LessonPrice lessonPrice;
    private BookingStatus status;

    Booking(BookingTemplate template, PlanBookingRequested event) {
        this.bookingId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
        this.meetingDuration = new MeetingDuration(event.startTime, event.endTime);
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

    public MeetingCost calculateBaseMeetingCost() {
        var calculatedCost = lessonPrice.price
                .multiply(this.meetingDuration.partOfHour())
                .setScale(2, RoundingMode.HALF_UP);
        return new MeetingCost(calculatedCost, this.lessonPrice.currency);
    }

    public void approve() {
        // TODO - publish event
        if (this.status.canBeApproved()) {
            this.status = BookingStatus.APPROVED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void cancel() {
        // TODO - publish event
        if (this.status.canBeCancelled()) {
            this.status = BookingStatus.CANCELED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void accept() {
        // TODO - publish event
        if (this.status.canBeAccepted()) {
            this.status = BookingStatus.ACCEPTED;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
