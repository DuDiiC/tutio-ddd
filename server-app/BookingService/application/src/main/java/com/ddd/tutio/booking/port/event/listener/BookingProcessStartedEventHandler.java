package com.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.BookingProcessStarted;

public interface BookingProcessStartedEventHandler {

    void handle(BookingProcessStarted event);
}
