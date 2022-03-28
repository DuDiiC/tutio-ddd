package com.ddd.tutio.course;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.tutor.TutorId;

public class Course implements AggregateRoot<CourseId> {

    private CourseId courseId;

    // other aggregates
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
}
