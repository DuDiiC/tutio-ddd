package com.ddd.tutio.reservation;

import com.ddd.tutio.base.AggregateRoot;

class Reservation implements AggregateRoot<ReservationId> {

    private final ReservationId reservationId;

    Reservation(ReservationTemplate template) {
        this.reservationId = template.getIdentifier();
    }

    @Override
    public ReservationId getIdentifier() {
        return null;
    }
}
