package com.student.course.service;

import com.student.course.domain.Student;
import com.student.course.dto.StudentDTO;
import com.student.course.dto.mapper.StudentMapper;
import com.student.course.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    public Student findById(Long studentId) {
        return this.studentRepository.findById(studentId).orElse(null);
    }

    public Student save(StudentDTO studentDTO) {
        Student student = StudentMapper.mapStudent(studentDTO);
        return this.studentRepository.save(student);
    }
}
