package com.student.course.controller;

import com.student.course.domain.Instructor;
import com.student.course.dto.InstructorDTO;
import com.student.course.service.InstructorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@Slf4j
public class InstructorsController {

    private final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService) {
        this.instructorsService = instructorsService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        log.debug("REST request to get a page of instructors");
        List<Instructor> instructorList = instructorsService.findAll();
        return ResponseEntity.ok().body(instructorList);
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody InstructorDTO instructorDto) {
        log.debug("REST request to create a page of instructors");
        Instructor instructor = instructorsService.save(instructorDto);
        return ResponseEntity.ok().body(instructor);
    }
}
