package com.student.course.dto.mapper;

import com.student.course.domain.Instructor;
import com.student.course.dto.InstructorDTO;

public class InstructorMapper {


    public static Instructor mapInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setCreatedBy("admin");
        return instructor;
    }

    public static InstructorDTO mapInstructorToDto(Instructor instructor) {
        InstructorDTO instructorDto = new InstructorDTO();
        if(instructor!=null) {
            instructorDto.setName(instructor.getName());
            instructorDto.setId(instructor.getId());
        }
        return instructorDto;
    }
}
