package com.student.course.service;

import com.student.course.domain.Course;
import com.student.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    public Course findByCourseId(Long courseId) {
        return this.courseRepository.findById(courseId).orElse(null);
    }


    public Course create(Course course) {
        return this.courseRepository.save(course);
    }
}
