package com.ddd.tutio.course;

import com.ddd.tutio.base.AggregateRepository;

import java.util.UUID;

public interface CourseRepository extends AggregateRepository<CourseId, Course> {

    @Override
    default CourseId generateNext() {
        return new CourseId(UUID.randomUUID());
    }
}
