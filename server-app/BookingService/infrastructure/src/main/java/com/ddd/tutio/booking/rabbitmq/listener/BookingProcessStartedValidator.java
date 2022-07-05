package com.ddd.tutio.booking.rabbitmq.listener;

import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.course.CourseRepository;
import com.ddd.tutio.pupil.PupilRepository;
import org.springframework.stereotype.Component;

@Component
class BookingProcessStartedValidator {


    private final PupilRepository pupilRepository;
    private final CourseRepository courseRepository;

    BookingProcessStartedValidator(PupilRepository pupilRepository, CourseRepository courseRepository) {
        this.pupilRepository = pupilRepository;
        this.courseRepository = courseRepository;
    }

    boolean validate(BookingProcessStarted event) {
        return pupilRepository.existsById(event.pupilId) && courseRepository.existsById(event.courseId);
    }
}
