package comd.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.BookingProcessStarted;

public interface BookingProcessStartedEventHandler {

    /**
     * rozpoczęto proces rezerwacji -> rozpocznij odliczanie czasu przeznaczonego na rezerwację
     */
    void handle(BookingProcessStarted event);
}
