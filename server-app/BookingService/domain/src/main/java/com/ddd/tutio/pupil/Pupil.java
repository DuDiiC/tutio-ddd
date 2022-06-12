package com.ddd.tutio.pupil;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;

import java.util.Collections;
import java.util.List;

/**
 * <b>Agregat</b> ucznia, który dokonał rezerwacji.
 */
public class Pupil implements AggregateRoot<PupilId> {

    private PupilId pupilId;

    protected Pupil() {
    }

    @Override
    public PupilId getIdentifier() {
        return this.pupilId;
    }

    @Override
    public List<DomainEvent> events() {
        return Collections.emptyList();
    }
}
