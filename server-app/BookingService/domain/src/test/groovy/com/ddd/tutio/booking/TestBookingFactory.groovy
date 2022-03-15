package com.ddd.tutio.booking

import com.ddd.tutio.course.CourseId
import com.ddd.tutio.pupil.PupilId

import java.time.Duration
import java.time.Instant

trait TestBookingFactory {

    private static final String RESERVATION_ID = "4ef61674-7608-11ec-90d6-0242ac120003"
    private static final String COURSE_ID = "6a1a1932-7608-11ec-90d6-0242ac120003"
    private static final String PUPIL_ID = "7b766e56-7608-11ec-90d6-0242ac120003"

    Booking getSimpleInstance() {
        return new Booking(
                new BookingTemplate(
                        new BookingId(UUID.fromString(RESERVATION_ID)),
                        new CourseId(UUID.fromString(COURSE_ID)),
                        new PupilId(UUID.fromString(PUPIL_ID)),
                        new BigDecimal("100.00")),
                Instant.now(), Instant.now() + Duration.ofHours(1)
        )
    }

    Booking getInstance(Instant meetingStartTime, Duration meetingDuration, BigDecimal lessonPrice) {
        return new Booking(
                new BookingTemplate(
                        new BookingId(UUID.fromString(RESERVATION_ID)),
                        new CourseId(UUID.fromString(COURSE_ID)),
                        new PupilId(UUID.fromString(PUPIL_ID)),
                        lessonPrice),
                meetingStartTime, meetingStartTime + meetingDuration
        )
    }
}
