package com.ddd.tutio.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

/**
 * Obiekt wartości czasu trwania spotkania.
 */
class MeetingDuration implements Serializable {

    /**
     * Minimalny czas trwania spotkania (30 minut).
     */
    private static final long MINIMUM_MEETING_DURATION_IN_MILLIS = 30 * 60 * 1000L;

    /**
     * Maksymalny czas trwania spotkania (180 minut).
     */
    private static final long MAXIMUM_MEETING_DURATION_IN_MILLIS = 3 * 60 * 60 * 1000L;

    /**
     * Punkt w czasie planowanego początku spotkania.
     */
    Instant startTime;

    /**
     * Punkt w czasie planowanego zakończenia spotkania.
     */
    Instant endTime;

    protected MeetingDuration() {
    }

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

    /**
     * Zwraca liczbę (z dokładnością do czterech miejsc po przecinku, zaokrąglaną w górę) reprezentującą część godziny, jakiej odpowiada długość spotkania.
     * @return
     */
    BigDecimal partOfHour() {
        return BigDecimal
                .valueOf(duration().toMinutes())
                .divide(BigDecimal.valueOf(60L), 4, RoundingMode.CEILING);
    }

    /**
     * Zwraca obiekt {@link Duration}, reprezentujący przedział czasu trwania spotkania.
     */
    Duration duration() {
        return Duration.between(this.startTime, this.endTime)
                .plusMinutes(1)
                .minusSeconds(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingDuration that = (MeetingDuration) o;
        return startTime.equals(that.startTime) && endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}
