package com.ddd.tutio.course;

import java.io.Serializable;
import java.util.UUID;

public class CourseId implements Serializable {
    public UUID id;

    protected CourseId() {
    }

    public CourseId(UUID id) {
        this.id = id;
    }
}
