package com.student.course.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A FeePayment.
 */
@Entity
@Table(name = "fee_payment")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FeePayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "fee_amount", nullable = false)
    private Long feeAmount;



    @Column(name = "fee_status")
    private String feeStatus;


    @ManyToOne
    @JoinColumn(name = "enroll_id", referencedColumnName = "id")
    private CourseEnrollment enrollId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FeePayment id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFeeAmount() {
        return this.feeAmount;
    }

    public FeePayment feeAmount(Long feeAmount) {
        this.setFeeAmount(feeAmount);
        return this;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public CourseEnrollment getEnrollId() {
        return this.enrollId;
    }

    public void setEnrollId(CourseEnrollment courseEnrollment) {
        this.enrollId = courseEnrollment;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }


    public FeePayment enrollId(CourseEnrollment courseEnrollment) {
        this.setEnrollId(courseEnrollment);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FeePayment)) {
            return false;
        }
        return id != null && id.equals(((FeePayment) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FeePayment{" +
            "id=" + getId() +
            ", feeAmount=" + getFeeAmount() +
            ", enrollId=" + getEnrollId() +
            "}";
    }
}
