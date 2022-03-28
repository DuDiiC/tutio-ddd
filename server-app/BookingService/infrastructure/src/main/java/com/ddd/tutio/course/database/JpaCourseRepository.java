package com.ddd.tutio.course.database;

import com.ddd.tutio.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface JpaCourseRepository extends JpaRepository<Course, UUID> {
}
