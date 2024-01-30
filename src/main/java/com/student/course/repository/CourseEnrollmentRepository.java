package com.student.course.repository;

import com.student.course.domain.CourseEnrollment;
import com.student.course.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

    List<CourseEnrollment> findCourseEnrollmentByStudentId(Student studentId);
}

