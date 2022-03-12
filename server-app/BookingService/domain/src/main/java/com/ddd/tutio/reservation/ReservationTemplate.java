package com.ddd.tutio.reservation;

import com.ddd.tutio.base.Aggregate;

class ReservationTemplate implements Aggregate<ReservationId> {

    private final ReservationId reservationId;

    public ReservationTemplate(ReservationId reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public ReservationId getIdentifier() {
        return null;
    }

    public Reservation toReservation() {
        return new Reservation(this);
    }
}
