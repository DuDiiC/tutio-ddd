package com.ddd.tutio.booking

import spock.lang.Specification

import java.time.Instant

class MeetingDurationTest extends Specification {

    def "Validation passed for appropriate instance"(String startTime, String endTime) {

        when: "Creating instance"
        new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime))

        then: "No exception has been thrown"
        noExceptionThrown()

        where: "Parameters"
        startTime                 | endTime
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:00:00.00Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:00.00Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:45:00.00Z" // exactly 30 minutes
        "2022-01-10T10:15:00.00Z" | "2022-01-10T13:15:00.00Z" // exactly 3 hours
    }

    def "Validation failed if end time is before start time"(String startTime, String endTime) {

        when: "Creating instance"
        new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime))

        then: "Validation failed"
        def ex = thrown(IllegalArgumentException)
        ex.message == "Meeting start time must be BEFORE meeting end time"

        where: "Parameters"
        startTime                 | endTime
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:14:59.99Z"
        "2022-01-10T10:15:00.00Z" | "2021-01-10T10:15:00.00Z"
    }

    def "Validation failed if meeting is shorter than 30 minutes"(String startTime, String endTime) {

        when: "Creating instance"
        new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime))

        then: "Validation failed"
        def ex = thrown(IllegalArgumentException)
        ex.message == "Too short meeting duration"

        where: "Parameters"
        startTime                 | endTime
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:15:00.00Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:15:00.01Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:30:00.00Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:44:59.99Z"
    }

    def "Validation failed if meeting is longer than 3 hours"(String startTime, String endTime) {

        when: "Creating instance"
        new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime))

        then: "Validation failed"
        def ex = thrown(IllegalArgumentException)
        ex.message == "Too long meeting duration"

        where: "Parameters"
        startTime                 | endTime
        "2022-01-10T10:15:00.00Z" | "2022-01-10T13:15:00.01Z"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T13:30:00.00Z"
        "2022-01-10T10:15:00.00Z" | "2022-02-10T10:00:00.00Z"
    }

    def "Calculate duration correctly"(String startTime, String endTime, long durationInMinutes) {

        given: "MeetingDuration instance"
        def instance = new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime));

        when: "Calculate duration"
        def result = instance.duration().toMinutes()

        then: "Calculate duration correctly"
        result == durationInMinutes

        where: "Parameters"
        startTime | endTime | durationInMinutes
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:00.00Z" | 60
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:00.01Z" | 60
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:01.00Z" | 61
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:16:01.29Z" | 62
    }

    def "Calculate part of hour correctly"(String startTime, String endTime, String partOfHour) {

        given: "MeetingDuration instance"
        def instance = new MeetingDuration(Instant.parse(startTime), Instant.parse(endTime));

        when: "Calculate part of hour"
        def result = instance.partOfHour()

        then: "Calculate part of hour correctly"
        result == new BigDecimal(partOfHour)

        where: "Parameters"
        startTime | endTime | partOfHour
        "2022-01-10T10:15:00.00Z" | "2022-01-10T10:45:00.00Z" | "0.5000"
        "2022-01-10T10:00:00.00Z" | "2022-01-10T10:40:00.00Z" | "0.6667"
        "2022-01-10T10:00:00.00Z" | "2022-01-10T10:45:00.00Z" | "0.7500"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:00.00Z" | "1.0000"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:15:01.00Z" | "1.0167"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:16:01.29Z" | "1.0334"
        "2022-01-10T10:15:00.00Z" | "2022-01-10T11:45:00.00Z" | "1.5000"
    }
}
