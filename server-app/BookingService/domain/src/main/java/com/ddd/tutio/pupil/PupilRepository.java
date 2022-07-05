package com.ddd.tutio.pupil;

import com.ddd.tutio.base.ReadOnlyAggregateRepository;
import com.ddd.tutio.course.Course;

public interface PupilRepository extends ReadOnlyAggregateRepository<PupilId, Pupil> {
}
