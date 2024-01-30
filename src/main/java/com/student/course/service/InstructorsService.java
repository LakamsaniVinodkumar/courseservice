package com.student.course.service;

import com.student.course.domain.Instructor;
import com.student.course.dto.InstructorDTO;
import com.student.course.dto.mapper.InstructorMapper;
import com.student.course.repository.InstructorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorsService {


    private final InstructorsRepository instructorsRepository;

    public InstructorsService(InstructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }

    public List<Instructor> findAll() {
        return this.instructorsRepository.findAll();
    }

    public Instructor save(InstructorDTO instructorDto) {
        Instructor instructor = InstructorMapper.mapInstructor(instructorDto);
        return this.instructorsRepository.save(instructor);
    }
}
