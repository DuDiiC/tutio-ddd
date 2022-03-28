package com.ddd.tutio.pupil;

import com.ddd.tutio.base.AggregateRoot;

public class Pupil implements AggregateRoot<PupilId> {

    private PupilId pupilId;

    protected Pupil() {
    }

    @Override
    public PupilId getIdentifier() {
        return this.pupilId;
    }
}
