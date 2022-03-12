package com.ddd.tutio.reservation;

import com.ddd.tutio.base.Aggregate;

class Reservation implements Aggregate<ReservationId> {

    private final ReservationId reservationId;

    Reservation(ReservationTemplate template) {
        this.reservationId = template.getIdentifier();
    }

    @Override
    public ReservationId getIdentifier() {
        return null;
    }
}
