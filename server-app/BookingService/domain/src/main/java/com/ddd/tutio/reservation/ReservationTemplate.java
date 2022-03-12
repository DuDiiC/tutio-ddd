package com.ddd.tutio.reservation;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

class ReservationTemplate implements AggregateRoot<ReservationId> {

    private final ReservationId reservationId;

    // other aggregates
    final PupilId pupilId;
    final CourseId courseId;

    public ReservationTemplate(ReservationId reservationId, CourseId courseId, PupilId pupilId) {
        this.reservationId = reservationId;
        this.courseId = courseId;
        this.pupilId = pupilId;
    }

    @Override
    public ReservationId getIdentifier() {
        return this.reservationId;
    }

    public Reservation toReservation() {
        return new Reservation(this);
    }
}
