package com.ddd.tutio.course;

import com.ddd.tutio.base.ReadOnlyAggregateRepository;
import com.ddd.tutio.booking.Booking;

public interface CourseRepository extends ReadOnlyAggregateRepository<CourseId, Course> {
}
