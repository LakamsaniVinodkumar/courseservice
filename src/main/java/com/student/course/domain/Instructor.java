package com.student.course.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Instructor.
 */
@Entity
@Table(name = "instructor")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Instructor extends AbstractAuditingEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "instructorId")
    @JsonBackReference
    private Set<Course> ids = new HashSet<>();


    public Long getId() {
        return this.id;
    }

    public Instructor id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Instructor name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getIds() {
        return this.ids;
    }

    public void setIds(Set<Course> courses) {
        if (courses != null) {
            courses.forEach(i -> i.setInstructorId(this));
        }
        this.ids = courses;
    }

    public Instructor ids(Set<Course> courses) {
        this.setIds(courses);
        return this;
    }

    public Instructor addId(Course course) {
        this.ids.add(course);
        course.setInstructorId(this);
        return this;
    }

    public Instructor removeId(Course course) {
        this.ids.remove(course);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Instructor)) {
            return false;
        }
        return id != null && id.equals(((Instructor) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Instructor{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
