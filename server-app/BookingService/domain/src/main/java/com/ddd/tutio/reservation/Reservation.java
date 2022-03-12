package com.ddd.tutio.reservation;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

class Reservation implements AggregateRoot<ReservationId> {

    private final ReservationId reservationId;

    // other aggregates
    final CourseId courseId;
    final PupilId pupilId;

    Reservation(ReservationTemplate template) {
        this.reservationId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
    }

    @Override
    public ReservationId getIdentifier() {
        return this.reservationId;
    }
}
