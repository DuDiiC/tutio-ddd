package com.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.*;

/**
 * Klasa przechowująca definicje interfejsów przechwytujących zdarzenia domenowe, których zakres funkcjonalności został określony,
 * jednak nie zostały jeszcze zaimplementowane.
 */
abstract class NoImplementedYetBookingEventHandlers {
    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingCountdownStarted}.
     */
    private interface BookingCountdownStartedEventHandler {

        /**
         * początek odliczania czasu przeznaczonego na dokonanie rezerwacji
         */
        void handle(BookingCountdownStarted event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link TimeForBookingExpired}.
     */
    private interface TimeForBookingExpiredEventHandler {
        /**
         * czas przeznaczony na dokonanie rezerwacji upłynął -> usuń rezerwację
         */
        void handle(TimeForBookingExpired event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link PlanBookingRequested}.
     */
    private interface PlanBookingRequestedEventHandler {
        /**
         * zlecono rezerwację w wybranym terminie -> spróbuj utworzyć planowaną rezerwację
         */
        void handle(PlanBookingRequested event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingPlanned}.
     */
    private interface BookingPlannedEventHandler {
        /**
         * pomyślnie zaplanowano rezerwację -> oblicz koszt spotkania
         */
        void handle(BookingPlanned event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingPlanningRejected}.
     */
    private interface BookingRejectedEventHandler {
        /**
         * odmówiono zaplanowania rezerwacji -> usuń rezerwację
         */
        void handle(BookingPlanningRejected event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link MeetingCostCalculated}.
     */
    private interface MeetingCostCalculatedEventHandler {
        /**
         * obliczono koszt spotkania -> zleć pobranie opłaty od ucznia
         */
        void handle(MeetingCostCalculated event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingPaidSuccessfully}.
     */
    private interface BookingPaidSuccessfullyEventHandler {
        /**
         * opłacono rezerwację (z kontekstu PLATNOŚCI) -> zatwierdź rezerwację
         */
        void handle(BookingPaidSuccessfully event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingApproved}.
     */
    private interface BookingApprovedEventHandler {
        /**
         * zatwierdzono rezerwację -> powiadom nauczyciela i ucznia, rozpocznij naliczanie czasu do akceptacji przez nauczyciela
         */
        void handle(BookingApproved event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingPaymentFailed}.
     */
    private interface BookingPaymentFailedEventHandler {
        /**
         * nieudana operacja opłacenia rezerwacji (z kontekstu PLATNOŚCI) -> anuluj rezerwację
         */
        void handle(BookingPaymentFailed event);
    }

    /**
     * Interfejs zapewniający przechwytywanie zdarzenia domenowego {@link BookingCancelled}.
     */
    private interface BookingCancelledEventHandler {
        /**
         * anulowano rezerwację -> powiadom ucznia o anulowaniu rezerwacji i powodzie anulowania
         */
        void handle(BookingCancelled event);
    }
}
