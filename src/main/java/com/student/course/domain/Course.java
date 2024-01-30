package com.student.course.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Course.
 */
@Entity
@Table(name = "course")
public class Course extends AbstractAuditingEntity<Long> implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @NotNull
    @Column(name = "course_code", nullable = false)
    private String courseCode;


    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructorId;

    @OneToMany(mappedBy = "courseId",  cascade = CascadeType.ALL)
    private Set<CourseEnrollment> courseEnrollments = new HashSet<>();



    public Course id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Course courseName(String courseName) {
        this.setCourseName(courseName);
        return this;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public Course courseCode(String courseCode) {
        this.setCourseCode(courseCode);
        return this;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }



    public Set<CourseEnrollment> getCourseEnrollments() {
        return this.courseEnrollments;
    }

    public void setCourseEnrollments(Set<CourseEnrollment> courseEnrollments) {

        if (courseEnrollments != null) {
            courseEnrollments.forEach(i -> i.setCourseId(this));
        }
        this.courseEnrollments = courseEnrollments;
    }

    public Course courseEnrollments(Set<CourseEnrollment> courseEnrollments) {
        this.setCourseEnrollments(courseEnrollments);
        return this;
    }

    public Course addCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollments.add(courseEnrollment);
        courseEnrollment.setCourseId(this);
        return this;
    }

    public Course removeId(CourseEnrollment courseEnrollment) {
        this.courseEnrollments.remove(courseEnrollment);
        courseEnrollment.setCourseId(null);
        return this;
    }

    public Instructor getInstructorId() {
        return this.instructorId;
    }

    public void setInstructorId(Instructor instructor) {
        this.instructorId = instructor;
    }

    public Course instructorId(Instructor instructor) {
        this.setInstructorId(instructor);
        return this;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Course)) {
            return false;
        }
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Course{" +
            "id=" + getId() +
            ", courseName='" + getCourseName() + "'" +
            ", courseCode='" + getCourseCode() + "'" +
            ", instructorId=" + getInstructorId() +
            "}";
    }
}
