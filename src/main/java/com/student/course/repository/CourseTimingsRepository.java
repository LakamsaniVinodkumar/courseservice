package com.student.course.repository;

import com.student.course.domain.Course;
import com.student.course.domain.CourseTimings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseTimingsRepository extends JpaRepository<CourseTimings, Long> {

    List<CourseTimings> findByCourseId(Course courseId);
}
