package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.BookingId;
import com.ddd.tutio.booking.MeetingCost;
import com.ddd.tutio.pupil.PupilId;

import java.time.Instant;
import java.util.UUID;

public class MeetingCostCalculated extends DomainEvent {

    public final BookingId bookingId;
    public final PupilId pupilId;
    public final MeetingCost meetingCost;

    public MeetingCostCalculated(UUID eventId, Instant createdOn, BookingId bookingId, PupilId pupilId, MeetingCost meetingCost) {
        super(eventId, createdOn);
        this.bookingId = bookingId;
        this.pupilId = pupilId;
        this.meetingCost = meetingCost;
    }
}
