package com.ddd.tutio.course;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.tutor.TutorId;

class Course implements AggregateRoot<CourseId> {

    private final CourseId courseId;

    // other aggregates
    final TutorId tutorId;

    Course(CourseId courseId, TutorId tutorId) {
        this.courseId = courseId;
        this.tutorId = tutorId;
    }

    @Override
    public CourseId getIdentifier() {
        return this.courseId;
    }
}
