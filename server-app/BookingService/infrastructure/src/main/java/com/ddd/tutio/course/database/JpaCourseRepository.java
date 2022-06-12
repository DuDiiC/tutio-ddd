package com.ddd.tutio.course.database;

import com.ddd.tutio.course.Course;
import com.ddd.tutio.course.CourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Springowe repozytorium kursu.
 */
@Repository
interface JpaCourseRepository extends JpaRepository<Course, CourseId> {
}
