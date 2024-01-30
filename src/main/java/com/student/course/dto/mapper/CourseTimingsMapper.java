package com.student.course.dto.mapper;

import com.student.course.domain.CourseTimings;
import com.student.course.dto.CourseTimingsDTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CourseTimingsMapper {

    public static CourseTimings mapCourseTiming(CourseTimingsDTO studentDTO) {
        CourseTimings courseTimings = new CourseTimings();
        LocalDateTime startDateTime = LocalDateTime.parse(
                studentDTO.getStartDate() ,
                DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm" )
        ).atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDateTime endDateTime = LocalDateTime.parse(
                studentDTO.getEndDate() ,
                DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm" )
        ).atZone(ZoneId.systemDefault()).toLocalDateTime();

        Instant startDate = startDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Instant endDate = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        courseTimings.setStartDate(startDate);
        courseTimings.setEndDate(endDate);
        courseTimings.setDuration(studentDTO.getDuration());
        return courseTimings;
    }


    public static CourseTimingsDTO mapCourseTimingsToDto(CourseTimings courseTimings) {
        CourseTimingsDTO courseDTO = new CourseTimingsDTO();
        courseDTO.setCourseId(CourseMapper.mapCourseToDto(courseTimings.getCourseId()));
        courseDTO.setStartDate(courseTimings.getStartDate().toString());
        courseDTO.setEndDate(courseTimings.getEndDate().toString());
        courseDTO.setDuration(courseTimings.getDuration());
        return courseDTO;
    }


    public static List<CourseTimingsDTO> mapCourseTimingsToDto(List<CourseTimings> courseList) {
        List<CourseTimingsDTO> courseDTOList = new ArrayList<>();
        for(CourseTimings course: courseList) {
            courseDTOList.add(mapCourseTimingsToDto(course));
        }
        return courseDTOList;
    }

}
