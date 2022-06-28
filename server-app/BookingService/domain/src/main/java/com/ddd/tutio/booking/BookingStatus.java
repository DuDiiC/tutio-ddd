package com.ddd.tutio.booking;

import java.io.Serializable;

public enum BookingStatus implements Serializable {

    PLANNED {
        @Override
        boolean canBeApproved() {
            return true;
        }

        @Override
        boolean canBeCancelled() {
            return true;
        }

        @Override
        boolean canBeAccepted() {
            return false;
        }
    },

    APPROVED {
        @Override
        boolean canBeApproved() {
            return false;
        }

        @Override
        boolean canBeCancelled() {
            return false;
        }

        @Override
        boolean canBeAccepted() {
            return true;
        }
    },

    CANCELED {
        @Override
        boolean canBeApproved() {
            return false;
        }

        @Override
        boolean canBeCancelled() {
            return false;
        }

        @Override
        boolean canBeAccepted() {
            return false;
        }
    },

    ACCEPTED{
        @Override
        boolean canBeApproved() {
            return false;
        }

        @Override
        boolean canBeCancelled() {
            return false;
        }

        @Override
        boolean canBeAccepted() {
            return false;
        }
    };

    abstract boolean canBeApproved();

    abstract boolean canBeCancelled();

    abstract boolean canBeAccepted();
}
