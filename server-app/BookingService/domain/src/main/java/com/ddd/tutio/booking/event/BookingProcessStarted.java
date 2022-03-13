package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class BookingProcessStarted extends DomainEvent {

    public final CourseId courseId;
    public final PupilId pupilId;
    public final BigDecimal lessonPrice;

    public BookingProcessStarted(UUID eventId, Instant createdOn, CourseId courseId, PupilId pupilId, BigDecimal lessonPrice) {
        super(eventId, createdOn);
        this.courseId = courseId;
        this.pupilId = pupilId;
        this.lessonPrice = lessonPrice;
    }
}
