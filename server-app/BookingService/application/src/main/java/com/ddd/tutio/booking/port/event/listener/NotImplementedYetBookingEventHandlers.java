package com.ddd.tutio.booking.port.event.listener;

import com.ddd.tutio.booking.event.*;

abstract class NoImplementedYetBookingEventHandlers {

    private interface BookingCountdownStartedEventHandler {
        void handle(BookingCountdownStarted event);
    }

    private interface TimeForBookingExpiredEventHandler {
        void handle(TimeForBookingExpired event);
    }

    private interface PlanBookingRequestedEventHandler {
        void handle(PlanBookingRequested event);
    }

    private interface BookingPlannedEventHandler {
        void handle(BookingPlanned event);
    }

    private interface BookingRejectedEventHandler {
        void handle(BookingPlanningRejected event);
    }

    private interface MeetingCostCalculatedEventHandler {
        void handle(MeetingCostCalculated event);
    }

    private interface BookingPaidSuccessfullyEventHandler {
        void handle(BookingPaidSuccessfully event);
    }

    private interface BookingApprovedEventHandler {
        void handle(BookingApproved event);
    }

    private interface BookingPaymentFailedEventHandler {
        void handle(BookingPaymentFailed event);
    }

    private interface BookingCancelledEventHandler {
        void handle(BookingCancelled event);
    }
}
