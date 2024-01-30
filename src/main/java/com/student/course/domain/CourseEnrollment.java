package com.student.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A CourseEnrollment.
 */
@Entity
@Table(name = "course_enrollment")
public class CourseEnrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course courseId;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student studentId;

    @OneToMany(mappedBy = "enrollId")
    private Set<FeePayment> feePayments = new HashSet<>();


    public Long getId() {
        return this.id;
    }

    public CourseEnrollment id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public Set<FeePayment> getFeePayments() {
        return this.feePayments;
    }

    public void setIds(Set<FeePayment> feePayments) {
        if (feePayments != null) {
            feePayments.forEach(i -> i.setEnrollId(this));
        }
        this.feePayments = feePayments;
    }

    public CourseEnrollment ids(Set<FeePayment> feePayments) {
        this.setIds(feePayments);
        return this;
    }

    public CourseEnrollment addId(FeePayment feePayment) {
        this.feePayments.add(feePayment);
        feePayment.setEnrollId(this);
        return this;
    }

    public CourseEnrollment removeId(FeePayment feePayment) {
        this.feePayments.remove(feePayment);
        feePayment.setEnrollId(null);
        return this;
    }

    public Course getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Course course) {
        this.courseId = course;
    }

    public CourseEnrollment courseId(Course course) {
        this.setCourseId(course);
        return this;
    }

    public Student getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Student student) {
        this.studentId = student;
    }

    public CourseEnrollment studentId(Student student) {
        this.setStudentId(student);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseEnrollment)) {
            return false;
        }
        return id != null && id.equals(((CourseEnrollment) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseEnrollment{" +
            "id=" + getId() +
            ", courseId=" + getCourseId() +
            ", studentId=" + getStudentId() +
            "}";
    }
}
