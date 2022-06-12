package com.ddd.tutio.course;

import com.ddd.tutio.base.ReadOnlyAggregateRepository;
import com.ddd.tutio.booking.Booking;

/**
 * Implementacja wzorca taktycznego <b>repozytorium</b> dla agregatu kursu {@link Course}.
 */
public interface CourseRepository extends ReadOnlyAggregateRepository<CourseId, Course> {
}
