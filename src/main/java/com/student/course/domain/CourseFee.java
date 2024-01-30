package com.student.course.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A CourseFee.
 */
@Entity
@Table(name = "course_fee")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CourseFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "cost", nullable = false)
    private Long cost;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Long duration;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Course courseId;


    public Long getId() {
        return this.id;
    }

    public CourseFee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return this.cost;
    }

    public CourseFee cost(Long cost) {
        this.setCost(cost);
        return this;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getDuration() {
        return this.duration;
    }

    public CourseFee duration(Long duration) {
        this.setDuration(duration);
        return this;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Course getCourseId() {
        return this.courseId;
    }


    public void setCourseId(Course course) {
        this.courseId = course;
    }

    public CourseFee courseId(Course course) {
        this.setCourseId(course);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseFee)) {
            return false;
        }
        return id != null && id.equals(((CourseFee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseFee{" +
            "id=" + getId() +
            ", cost=" + getCost() +
            ", duration=" + getDuration() +
            ", courseId=" + getCourseId() +
            "}";
    }
}
