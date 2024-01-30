package com.student.course.dto;



public class CourseEnrollmentDTO {


    private CourseDTO courseId;
    private StudentDTO studentId;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseDTO getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseDTO courseId) {
        this.courseId = courseId;
    }

    public StudentDTO getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentDTO studentId) {
        this.studentId = studentId;
    }
}
