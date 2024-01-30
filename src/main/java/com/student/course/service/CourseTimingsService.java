package com.student.course.service;

import com.student.course.domain.Course;
import com.student.course.domain.CourseTimings;
import com.student.course.repository.CourseRepository;
import com.student.course.repository.CourseTimingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTimingsService {

    private final CourseTimingsRepository courseTimingsRepository;

    private final CourseRepository courseRepository;

    public CourseTimingsService(CourseTimingsRepository courseTimingsRepository,
                                final CourseRepository courseRepository) {
        this.courseTimingsRepository = courseTimingsRepository;
        this.courseRepository = courseRepository;
    }

    public List<CourseTimings> findAll() {
        return this.courseTimingsRepository.findAll();
    }

    public List<CourseTimings> findByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        return this.courseTimingsRepository.findByCourseId(course);
    }

    public CourseTimings create(CourseTimings courseTimings) {
        return this.courseTimingsRepository.save(courseTimings);
    }

}
