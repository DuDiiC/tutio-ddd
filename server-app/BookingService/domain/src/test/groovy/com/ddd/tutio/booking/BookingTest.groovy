package com.ddd.tutio.booking

import com.ddd.tutio.course.CourseId
import com.ddd.tutio.pupil.PupilId
import spock.lang.Specification

import java.time.Duration
import java.time.Instant

class BookingTest extends Specification {

    def "Calculate meeting cost correctly"(String startTime, Long duration, String lessonPrice, String resultAmount) {

        given: "Booking aggregate instance"
        def booking = TestBookingFactory.getInstance(Instant.parse(startTime), Duration.ofMinutes(duration), new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def result = booking.calculateMeetingCost()

        then: "Calculate meeting cost correctly"
        result.currency == Currency.PLN
        result.amount == new BigDecimal(resultAmount)

        where: "Parameters"
        startTime                 | duration | lessonPrice || resultAmount
        "2022-01-10T10:15:00.00Z" | 45L      | "50.00"     || "37.50"
        "2022-01-10T10:00:00.00Z" | 60L      | "50.00"     || "50.00"
        "2022-01-10T10:15:00.00Z" | 90L      | "50.00"     || "75.00"
        "2022-01-10T10:00:00.00Z" | 70L      | "50.00"     || "58.34"
    }

    private class TestBookingFactory {

        private static final String RESERVATION_ID = "4ef61674-7608-11ec-90d6-0242ac120003"
        private static final String COURSE_ID = "6a1a1932-7608-11ec-90d6-0242ac120003"
        private static final String PUPIL_ID = "7b766e56-7608-11ec-90d6-0242ac120003"

        static Booking getInstance(Instant meetingStartTime, Duration meetingDuration, BigDecimal lessonPrice) {
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
}
