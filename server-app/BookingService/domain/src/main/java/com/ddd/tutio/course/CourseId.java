package com.ddd.tutio.course;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CourseId implements Serializable {

    public UUID id;

    protected CourseId() {
    }

    public CourseId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseId courseId = (CourseId) o;
        return id.equals(courseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
