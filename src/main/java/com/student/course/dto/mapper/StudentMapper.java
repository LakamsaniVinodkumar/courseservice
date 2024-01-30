package com.student.course.dto.mapper;

import com.student.course.domain.Student;
import com.student.course.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {


    public static Student mapStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setLogin(studentDTO.getFirstName());
        student.setPassword("test");
        student.setActivationKey("Active");
        return student;
    }


    public static StudentDTO mapStudentToDto(Student student) {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setId(student.getId());
        return studentDto;
    }

    public static List<StudentDTO> mapStudentToDto(List<Student> students) {
        List<StudentDTO> studentDtoList = new ArrayList<>();
        for(Student student : students) {
            studentDtoList.add(mapStudentToDto(student));
        }
        return studentDtoList;
    }

}
