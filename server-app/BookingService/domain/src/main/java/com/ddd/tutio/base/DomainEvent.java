package com.ddd.tutio.base;

import java.time.Instant;
import java.util.UUID;

/**
 * Klasa abstrakcyjna reprezentująca wzorzec taktyczny <b>zdarzenia domenowego</b>.
 */
public abstract class DomainEvent {

    /**
     * Unikalny identyfikator zdarzenia domenowego.
     */
    public final UUID eventId;

    /**
     * Czas powstania zdarzenia domenowego.
     */
    public final Instant createdOn;

    public DomainEvent(UUID eventId, Instant createdOn) {
        this.eventId = eventId;
        this.createdOn = createdOn;
    }
}
