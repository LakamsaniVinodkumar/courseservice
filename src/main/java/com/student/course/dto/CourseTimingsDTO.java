package com.student.course.dto;


import java.time.Instant;

public class CourseTimingsDTO {

    private Long id;
    private String startDate;
    private String endDate;
    private Integer duration;
    private CourseDTO courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public CourseDTO getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseDTO courseId) {
        this.courseId = courseId;
    }
}
