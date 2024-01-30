package com.student.course.controller;

import com.student.course.domain.Course;
import com.student.course.dto.CourseDTO;
import com.student.course.dto.mapper.CourseMapper;
import com.student.course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        log.debug("REST request to get a page of Courses");
        List<CourseDTO> coursesList = CourseMapper.mapCourseToDto(courseService.findAll());
        return ResponseEntity.ok().body(coursesList);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable Long courseId) {
        log.debug("REST request to get a page of Courses");
        CourseDTO course = CourseMapper.mapCourseToDto(courseService.findByCourseId(courseId));
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        log.debug("REST request to get a page of Courses");
        Course courseData = courseService.create(course);
        return ResponseEntity.ok().body(courseData);
    }
}
