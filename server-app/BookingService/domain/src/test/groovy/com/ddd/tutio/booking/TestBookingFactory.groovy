package com.ddd.tutio.booking

import com.ddd.tutio.booking.event.BookingProcessStarted
import com.ddd.tutio.course.CourseId
import com.ddd.tutio.pupil.PupilId

import java.time.Duration
import java.time.Instant

trait TestBookingFactory {

    private static final UUID EXAMPLE_IDENTIFIER = UUID.fromString("4ef61674-7608-11ec-90d6-0242ac120003")

    Booking getSimpleInstance() {
        BookingProcessStarted event = new BookingProcessStarted(
                EXAMPLE_IDENTIFIER, Instant.now(),
                new CourseId(EXAMPLE_IDENTIFIER),
                new PupilId(EXAMPLE_IDENTIFIER),
                new BigDecimal("100.00"))
        return new Booking(
                new BookingTemplate(new BookingId(EXAMPLE_IDENTIFIER),
                        new BookingProcessStarted(
                                EXAMPLE_IDENTIFIER, Instant.now(),
                                new CourseId(EXAMPLE_IDENTIFIER),
                                new PupilId(EXAMPLE_IDENTIFIER),
                                new BigDecimal("100.00"))),
                Instant.now(), Instant.now() + Duration.ofHours(1)
        )
    }

    Booking getInstance(Instant meetingStartTime, Duration meetingDuration, BigDecimal lessonPrice) {
        BookingProcessStarted event = new BookingProcessStarted(
                EXAMPLE_IDENTIFIER, Instant.now(),
                new CourseId(EXAMPLE_IDENTIFIER),
                new PupilId(EXAMPLE_IDENTIFIER),
                lessonPrice)
        return new Booking(
                new BookingTemplate(new BookingId(EXAMPLE_IDENTIFIER),
                        new BookingProcessStarted(
                                EXAMPLE_IDENTIFIER, Instant.now(),
                                new CourseId(EXAMPLE_IDENTIFIER),
                                new PupilId(EXAMPLE_IDENTIFIER),
                                new BigDecimal("100.00"))),
                meetingStartTime, meetingStartTime + meetingDuration
        )
    }
}
