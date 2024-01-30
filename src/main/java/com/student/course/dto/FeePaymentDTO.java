package com.student.course.dto;

public class FeePaymentDTO {

    private Long id;
    private StudentDTO studentId;
    private CourseDTO courseId;
    private Long feeAmount;
    private String feeStatus;

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public StudentDTO getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentDTO studentId) {
        this.studentId = studentId;
    }

    public CourseDTO getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseDTO courseId) {
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
