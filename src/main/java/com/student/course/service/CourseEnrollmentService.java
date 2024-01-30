package com.student.course.service;

import com.student.course.domain.Course;
import com.student.course.domain.CourseEnrollment;
import com.student.course.domain.Student;
import com.student.course.repository.CourseEnrollmentRepository;
import com.student.course.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    private final StudentRepository studentRepository;

    public CourseEnrollmentService(CourseEnrollmentRepository courseEnrollmentRepository,
                                   StudentRepository studentRepository) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
        this.studentRepository = studentRepository;
    }

    public List<CourseEnrollment> findAll() {
        return this.courseEnrollmentRepository.findAll();
    }


    public CourseEnrollment create(CourseEnrollment courseEnrollment) {
        return this.courseEnrollmentRepository.save(courseEnrollment);
    }

    public List<CourseEnrollment> findByStudentId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return this.courseEnrollmentRepository.findCourseEnrollmentByStudentId(student.orElse(null));
    }
}
