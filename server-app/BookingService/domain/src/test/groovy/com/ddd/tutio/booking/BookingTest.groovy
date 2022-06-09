package com.ddd.tutio.booking

import spock.lang.Specification

import java.time.Duration
import java.time.Instant

class BookingTest extends Specification implements TestBookingFactory {

    def "Calculate base meeting cost correctly"(
            String startTime, Long duration, String lessonPrice, String resultAmount
    ) {
        given: "Booking aggregate instance"
        def booking = getInstance(Instant.parse(startTime), Duration.ofMinutes(duration), new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def result = booking.calculateBaseMeetingCost()

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

    def "Change status correctly: PLANNED -> APPROVED"() {
        given: "Booking aggregate instance"
        def booking = getSimpleInstance()

        when: "Try to approve booking"
        booking.approve()

        then: "Approve booking"
        noExceptionThrown()
        booking.status() == BookingStatus.APPROVED
    }

    def "Change status correctly: PLANNED -> CANCELED"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()

        when: "Try to cancel booking"
        booking.cancel("")

        then: "Cancel booking"
        noExceptionThrown()
        booking.status() == BookingStatus.CANCELED
    }

    def "Change status correctly: APPROVED -> ACCEPTED"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()
        booking.approve()

        when: "Try to aceept booking"
        booking.accept()

        then: "Accept booking"
        noExceptionThrown()
        booking.status() == BookingStatus.ACCEPTED
    }

    def "Throw exception when try to approve approved booking"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()
        booking.approve()

        when: "Try to approve approved booking"
        booking.approve()

        then: "Throw exception"
        thrown(UnsupportedOperationException.class)
    }

    def "Throw exception when try to approve canceled booking"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()
        booking.cancel("")

        when: "Approve canceled booking"
        booking.approve()

        then: "Throw exception"
        thrown(UnsupportedOperationException.class)
    }

    def "Throw exception when try to cancel approved booking"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()
        booking.approve()

        when: "Try to cancel canceled booking"
        booking.cancel("")

        then: "Throw exception"
        thrown(UnsupportedOperationException.class)
    }

    def "Throw exception when try to accept planned booking"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()

        when: "Try to accept planned booking"
        booking.accept()

        then: "Throw exception"
        thrown(UnsupportedOperationException.class)
    }

    def "Throw exception when try to accept canceled booking"() {

        given: "Booking aggregate instance"
        def booking = getSimpleInstance()
        booking.cancel("")

        when: "Try to accept canceled booking"
        booking.accept()

        then: "Throw exception"
        thrown(UnsupportedOperationException.class)
    }
}
