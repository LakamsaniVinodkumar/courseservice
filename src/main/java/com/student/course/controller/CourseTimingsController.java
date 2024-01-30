package com.student.course.controller;

import com.student.course.domain.Course;
import com.student.course.domain.CourseTimings;
import com.student.course.dto.CourseTimingsDTO;
import com.student.course.dto.mapper.CourseTimingsMapper;
import com.student.course.service.CourseService;
import com.student.course.service.CourseTimingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courseTimings")
@Slf4j
public class CourseTimingsController {

    private final CourseTimingsService courseTimingsService;

    private final CourseService courseService;

    public CourseTimingsController(CourseTimingsService courseTimingsService,
                                   CourseService courseService) {
        this.courseTimingsService = courseTimingsService;
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseTimingsDTO>> findAll() {
        log.debug("REST request to get a page of Courses");
        List<CourseTimingsDTO> courseTimingsList = CourseTimingsMapper.mapCourseTimingsToDto(courseTimingsService.findAll());
        return ResponseEntity.ok().body(courseTimingsList);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<List<CourseTimingsDTO>> findByCourseId(@PathVariable(value = "courseId") Long courseId) {
        log.debug("REST request to get a page of Courses");
        List<CourseTimingsDTO> courseTimingsList = CourseTimingsMapper.mapCourseTimingsToDto(courseTimingsService.findByCourseId(courseId));
        return ResponseEntity.ok().body(courseTimingsList);
    }


    @PostMapping
    public ResponseEntity<CourseTimingsDTO> create(@RequestBody CourseTimingsDTO courseTimingsDto) {
        log.debug("REST request to get a page of Courses");
        CourseTimings courseTimings = CourseTimingsMapper.mapCourseTiming(courseTimingsDto);
        Course course = this.courseService.findByCourseId(courseTimingsDto.getCourseId().getId());
        courseTimings.setCourseId(course);
        CourseTimingsDTO courseTimingsList = CourseTimingsMapper.mapCourseTimingsToDto(courseTimingsService.create(courseTimings));
        return ResponseEntity.ok().body(courseTimingsList);
    }
}
