package com.ddd.tutio.pupil;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class PupilId implements Serializable {

    public UUID id;

    protected PupilId() {
    }

    public PupilId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PupilId pupilId = (PupilId) o;
        return id.equals(pupilId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
