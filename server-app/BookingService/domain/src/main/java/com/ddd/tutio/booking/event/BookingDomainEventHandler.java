package com.ddd.tutio.booking.event;

public interface BookingDomainEventHandler {

    /**
     * rozpoczęto proces rezerwacji -> rozpocznij odliczanie czasu przeznaczonego na rezerwację
     */
    void handle(BookingProcessStarted event);

    /**
     * czas przeznaczony na dokonanie rezerwacji upłynął -> usuń rezerwację
     */
    void handle(TimeForBookingExpired event);

    /**
     * zlecono rezerwację w wybranym terminie -> spróbuj utworzyć planowaną rezerwację
     */
    void handle(PlanBookingRequested event);

    /**
     * pomyślnie zaplanowano rezerwację -> oblicz koszt spotkania
     */
    void handle(BookingPlanned event);

    /**
     * odmówiono zaplanowania rezerwacji -> usuń rezerwację
     */
    void handle(BookingPlanningRejected event);

    /**
     * obliczono koszt spotkania -> zleć pobranie opłaty od ucznia
     */
    void handle(MeetingCostCalculated event);

    /**
     * opłacono rezerwację (z kontekstu PŁATNOŚCI) -> zatwierdź rezerwację
     */
    void handle(BookingPaidSuccessfully event);

    /**
     * zatwierdzono rezerwację -> powiadom nauczyciela i ucznia, rozpocznij naliczanie czasu do akceptacji przez nauczyciela
     */
    void handle(BookingApproved event);

    /**
     * nieudana operacja opłacenia rezerwacji (z kontekstu PŁATNOŚCI) -> anuluj rezerwację
     */
    void handle(BookingPaymentFailed event);

    /**
     * anulowano rezerwację -> powiadom ucznia o anulowaniu rezerwacji i powodzie anulowania
     */
    void handle(BookingCancelled event);
}
