package com.ddd.tutio.reservation;

import com.ddd.tutio.base.AggregateRoot;

class ReservationTemplate implements AggregateRoot<ReservationId> {

    private final ReservationId reservationId;

    public ReservationTemplate(ReservationId reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public ReservationId getIdentifier() {
        return this.reservationId;
    }

    public Reservation toReservation() {
        return new Reservation(this);
    }
}
