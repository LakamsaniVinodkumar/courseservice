package com.student.course.dto.mapper;

import com.student.course.domain.Course;
import com.student.course.dto.CourseDTO;
import com.student.course.dto.CourseEnrollmentDTO;

import java.util.ArrayList;
import java.util.List;


public class CourseMapper {


    public static CourseDTO mapCourseToDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setId(course.getId());
        courseDTO.setInstructorId(InstructorMapper.mapInstructorToDto(course.getInstructorId()));
        return courseDTO;
    }

    public static Course mapCourseDtoToCourse(CourseDTO course) {
        Course courseDTO = new Course();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setId(course.getId());
        return courseDTO;
    }


    public static List<CourseDTO> mapCourseToDto(List<Course> courseList) {
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for(Course course: courseList) {
            courseDTOList.add(mapCourseToDto(course));
        }
        return courseDTOList;
    }


}
