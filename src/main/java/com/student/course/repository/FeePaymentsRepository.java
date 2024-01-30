package com.student.course.repository;

import com.student.course.domain.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeePaymentsRepository extends JpaRepository<FeePayment, Long> {
}