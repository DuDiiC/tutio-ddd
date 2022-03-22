package com.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.*;

interface TimeForBookingExpiredEventHandler {
    /**
     * czas przeznaczony na dokonanie rezerwacji upłynął -> usuń rezerwację
     */
    void handle(TimeForBookingExpired event);
}

interface PlanBookingRequestedEventHandler {
    /**
     * zlecono rezerwację w wybranym terminie -> spróbuj utworzyć planowaną rezerwację
     */
    void handle(PlanBookingRequested event);
}

interface BookingPlannedEventHandler {
    /**
     * pomyślnie zaplanowano rezerwację -> oblicz koszt spotkania
     */
    void handle(BookingPlanned event);
}

interface BookingRejectedEventHandler {
    /**
     * odmówiono zaplanowania rezerwacji -> usuń rezerwację
     */
    void handle(BookingPlanningRejected event);
}

interface MeetingCostCalculatedEventHandler {
    /**
     * obliczono koszt spotkania -> zleć pobranie opłaty od ucznia
     */
    void handle(MeetingCostCalculated event);
}

interface BookingPaidSuccessfullyEventHandler {
    /**
     * opłacono rezerwację (z kontekstu PLATNOŚCI) -> zatwierdź rezerwację
     */
    void handle(BookingPaidSuccessfully event);
}

interface BookingApprovedEventHandler {
    /**
     * zatwierdzono rezerwację -> powiadom nauczyciela i ucznia, rozpocznij naliczanie czasu do akceptacji przez nauczyciela
     */
    void handle(BookingApproved event);
}

interface BookingPaymentFailedEventHandler {
    /**
     * nieudana operacja opłacenia rezerwacji (z kontekstu PLATNOŚCI) -> anuluj rezerwację
     */
    void handle(BookingPaymentFailed event);
}

interface BookingCancelledEventHandler {
    /**
     * anulowano rezerwację -> powiadom ucznia o anulowaniu rezerwacji i powodzie anulowania
     */
    void handle(BookingCancelled event);
}
