package com.ddd.tutio.booking;

import java.time.Duration;
import java.time.Instant;

class MeetingDuration {

    private static final long MINIMUM_MEETING_DURATION_IN_MILLIS = 30 * 60 * 1000L;
    private static final long MAXIMUM_MEETING_DURATION_IN_MILLIS = 3 * 60 * 60 * 1000L;

    final Instant startTime;
    final Instant endTime;

    public MeetingDuration(Instant startTime, Instant endTime) {
        validate(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private void validate(Instant startTime, Instant endTime) {
        Duration duration = Duration.between(startTime, endTime);
        if (duration.isNegative()) {
            throw new IllegalArgumentException("Meeting start time must be BEFORE meeting end time");
        }
        if (duration.toMillis() < MINIMUM_MEETING_DURATION_IN_MILLIS) {
            throw new IllegalArgumentException("Too short meeting duration");
        }
        if (duration.toMillis() > MAXIMUM_MEETING_DURATION_IN_MILLIS) {
            throw new IllegalArgumentException("Too long meeting duration");
        }
    }
}
