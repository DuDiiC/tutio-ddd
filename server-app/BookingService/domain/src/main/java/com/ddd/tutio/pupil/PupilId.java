package com.ddd.tutio.pupil;

import java.io.Serializable;
import java.util.UUID;

public class PupilId implements Serializable {

    public UUID id;

    protected PupilId() {
    }

    public PupilId(UUID id) {
        this.id = id;
    }
}
