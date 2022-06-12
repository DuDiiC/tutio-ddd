package com.ddd.tutio.course.database;

import com.ddd.tutio.course.Course;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.course.CourseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

/**
 * Implementacja repozytorium dla kursu, korzystająca ze springowego repozytorium dla bazy danych PostgreSQL.
 */
@Repository
public class PostgresCourseRepository implements CourseRepository {

    private final JpaCourseRepository jpaCourseRepository;

    public PostgresCourseRepository(JpaCourseRepository jpaCourseRepository) {
        this.jpaCourseRepository = jpaCourseRepository;
    }

    @Override
    public Course getById(CourseId courseId) {
        return jpaCourseRepository.findById(courseId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean existsById(CourseId courseId) {
        return jpaCourseRepository.existsById(courseId);
    }
}
