package com.student.course.controller;

import com.student.course.domain.CourseEnrollment;
import com.student.course.dto.CourseEnrollmentDTO;
import com.student.course.dto.mapper.CourseEnrollmentMapper;
import com.student.course.service.CourseEnrollmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courseEnrollments")
@Slf4j
public class CourseEnrollmentController {

    private final CourseEnrollmentService courseEnrollmentService;

    public CourseEnrollmentController(CourseEnrollmentService courseEnrollmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<CourseEnrollmentDTO>> findAll() {
        log.debug("REST request to get a page of Courses");
        List<CourseEnrollmentDTO> courseEnrollmentList = CourseEnrollmentMapper.mapCourseEnrollments(courseEnrollmentService.findAll());
        return ResponseEntity.ok().body(courseEnrollmentList);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<List<CourseEnrollmentDTO>> findByStudentId(@PathVariable Long studentId) {
        log.debug("REST request to get a page of Courses");
        List<CourseEnrollmentDTO> courseEnrollmentList = CourseEnrollmentMapper.mapCourseEnrollments(courseEnrollmentService.findByStudentId(studentId));
        return ResponseEntity.ok().body(courseEnrollmentList);
    }

    @PostMapping
    public ResponseEntity<CourseEnrollment> create(@RequestBody CourseEnrollment courseEnrollment) {
        log.debug("REST request to get a page of Courses");
        CourseEnrollment courseEnrollmentList = courseEnrollmentService.create(courseEnrollment);
        return ResponseEntity.ok().body(courseEnrollmentList);
    }
}
