package com.ddd.tutio.booking.event;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * <b>Zdarzenie domenowe</b> rozpoczęcia procesu rezerwacji.
 */
public class BookingProcessStarted extends DomainEvent {

    public final CourseId courseId;
    public final PupilId pupilId;
    public final BigDecimal lessonPrice;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BookingProcessStarted(
            @JsonProperty("eventId") UUID eventId,
            @JsonProperty("createdOn") Instant createdOn,
            @JsonProperty("courseId") CourseId courseId,
            @JsonProperty("pupilId") PupilId pupilId,
            @JsonProperty("lessonPrice") BigDecimal lessonPrice)
    {
        super(eventId, createdOn);
        this.courseId = courseId;
        this.pupilId = pupilId;
        this.lessonPrice = lessonPrice;
    }
}
