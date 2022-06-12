package com.ddd.tutio.booking;

import java.io.Serializable;

/**
 * Obiekt wartości statusu rezerwacji
 */
public enum BookingStatus implements Serializable {

    /**
     * Rezerwacja planowana. Status przyjmowany domyślnie po utworzeniu rezerwacji z szablonu {@link BookingTemplate}.
     */
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

    /**
     * Rezerwacja zatwierdzona. Status przyjmowany po opłaceniu spotkania przez ucznia.
     */
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

    /**
     * Rezerwacja anulowana. Status przyjmowany w przypadku gdy proces płatności zakończy się niepowodzeniem.
     */
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

    /**
     * Rezerwacja zaakceptowana. Status ten odpowiada utworzeniu planowanego spotkania.
     */
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

    /**
     * Informuje, czy rezerwacja o danym statusie może zostać zatwierdzona.
     * @return {@code true} jeśli rezerwacja może zostać zatwierdzona, {@code false} w przeciwnym wypadku.
     */
    abstract boolean canBeApproved();

    /**
     * Informuje, czy rezerwacja o danym statusie może zostać anulowana.
     * @return {@code true} jeśli rezerwacja może zostać anulowana, {@code false} w przeciwnym wypadku.
     */
    abstract boolean canBeCancelled();

    /**
     * Informuje, czy rezerwacja o danym statusie może zostać zaakceptowana.
     * @return {@code true} jeśli rezerwacja może zostać zaakceptowana, {@code false} w przeciwnym wypadku.
     */
    abstract boolean canBeAccepted();
}
