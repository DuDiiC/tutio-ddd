package com.ddd.tutio.base;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {

    public final UUID eventId;
    public final Instant createdOn;

    public DomainEvent(UUID eventId, Instant createdOn) {
        this.eventId = eventId;
        this.createdOn = createdOn;
    }
}
