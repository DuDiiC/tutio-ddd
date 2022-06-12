package com.ddd.tutio.course;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.tutor.TutorId;

import java.util.Collections;
import java.util.List;

/**
 * <b>Agregat</b> kursu powiązanego z rezerwacją.
 */
public class Course implements AggregateRoot<CourseId> {

    /**
     * Identyfikator kursu.
     */
    private CourseId courseId;

    /**
     * Identyfikator nauczyciela, do którego należy kurs.
     */
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
