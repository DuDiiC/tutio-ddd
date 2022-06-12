package com.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.BookingProcessStarted;

/**
 * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingProcessStarted}.
 */
public interface BookingProcessStartedEventHandler {

    /**
     * rozpoczęto proces rezerwacji -> rozpocznij odliczanie czasu przeznaczonego na rezerwację
     */
    void handle(BookingProcessStarted event);
}
