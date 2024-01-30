package com.student.course.dto.mapper;

import com.student.course.domain.CourseEnrollment;
import com.student.course.dto.CourseEnrollmentDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseEnrollmentMapper {

    public static List<CourseEnrollmentDTO> mapCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
        List<CourseEnrollmentDTO> courseEnrollmentDTOList = new ArrayList<>();
        for(CourseEnrollment courseEnrollment : courseEnrollments) {
            CourseEnrollmentDTO courseEnrollmentDTO = new CourseEnrollmentDTO();
            courseEnrollmentDTO.setId(courseEnrollment.getId());
            courseEnrollmentDTO.setCourseId(CourseMapper.mapCourseToDto(courseEnrollment.getCourseId()));
            courseEnrollmentDTO.setStudentId(StudentMapper.mapStudentToDto(courseEnrollment.getStudentId()));
            courseEnrollmentDTOList.add(courseEnrollmentDTO);
        }
        return courseEnrollmentDTOList;
    }
}
