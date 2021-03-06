package com.ddd.tutio.course;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.tutor.TutorId;

import java.util.Collections;
import java.util.List;

public class Course implements AggregateRoot<CourseId> {

    private CourseId courseId;

    TutorId tutorId;

    protected Course() {
    }

    Course(CourseId courseId, TutorId tutorId) {
        this.courseId = courseId;
        this.tutorId = tutorId;
    }

    @Override
    public CourseId getIdentifier() {
        return this.courseId;
    }

    @Override
    public List<DomainEvent> events() {
        return Collections.emptyList();
    }
}
