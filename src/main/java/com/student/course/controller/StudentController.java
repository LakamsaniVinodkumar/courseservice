package com.student.course.controller;

import com.student.course.domain.Student;
import com.student.course.dto.StudentDTO;
import com.student.course.dto.mapper.StudentMapper;
import com.student.course.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        log.debug("REST request to get a page of Courses");
        List<StudentDTO> studentList = StudentMapper.mapStudentToDto(studentService.findAll());
        return ResponseEntity.ok().body(studentList);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long studentId) {
        log.debug("REST request to get a page of Courses");
        StudentDTO student = StudentMapper.mapStudentToDto(studentService.findById(studentId));
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentDTO student) {
        log.debug("REST request to get a page of Courses");
        Student studentList = studentService.save(student);
        return ResponseEntity.ok().body(studentList);
    }
}
