package com.ddd.tutio.pupil;

import com.ddd.tutio.base.ReadOnlyAggregateRepository;
import com.ddd.tutio.course.Course;

/**
 * Implementacja wzorca taktycznego <b>repozytorium</b> dla agregatu ucznia {@link Pupil}.
 */
public interface PupilRepository extends ReadOnlyAggregateRepository<PupilId, Pupil> {
}
