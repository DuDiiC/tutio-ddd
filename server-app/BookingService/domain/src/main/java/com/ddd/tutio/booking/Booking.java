package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.event.BookingPlanned;
import com.ddd.tutio.booking.event.PlanBookingRequested;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Booking implements AggregateRoot<BookingId> {

    private List<DomainEvent> events = new ArrayList<>();

    private BookingId bookingId;
    // other aggregates
    private CourseId courseId;
    private PupilId pupilId;

    private MeetingDuration meetingDuration;
    private LessonPrice lessonPrice;
    private BookingStatus status;

    protected Booking() {
    }

    Booking(BookingTemplate template, PlanBookingRequested event) {
        this.bookingId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
        this.meetingDuration = new MeetingDuration(event.startTime, event.endTime);
        this.lessonPrice = template.lessonPrice;
        this.status = BookingStatus.PLANNED;

        events.add(new BookingPlanned(UUID.randomUUID(), Instant.now(), template.getIdentifier()));
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    @Override
    public List<DomainEvent> events() {
        return Collections.unmodifiableList(this.events);
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
