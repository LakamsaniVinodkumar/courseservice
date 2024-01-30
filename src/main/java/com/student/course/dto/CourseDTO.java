package com.student.course.dto;



public class CourseDTO {

    private Long id;
    private String courseName;
    private String courseCode;
    private InstructorDTO instructorId;

    public InstructorDTO getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(InstructorDTO instructorId) {
        this.instructorId = instructorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
