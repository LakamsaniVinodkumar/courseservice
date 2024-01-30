package com.student.course.service;

import com.student.course.domain.CourseEnrollment;
import com.student.course.domain.FeePayment;
import com.student.course.domain.Student;
import com.student.course.repository.CourseEnrollmentRepository;
import com.student.course.repository.FeePaymentsRepository;
import com.student.course.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeePaymentsService {

    private final FeePaymentsRepository feePaymentsRepository;

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    private final StudentRepository studentRepository;

    public FeePaymentsService(FeePaymentsRepository feePaymentsRepository,
                              final CourseEnrollmentRepository courseEnrollmentRepository,
                              final StudentRepository studentRepository) {
        this.feePaymentsRepository = feePaymentsRepository;
        this.courseEnrollmentRepository = courseEnrollmentRepository;
        this.studentRepository = studentRepository;
    }

    public List<FeePayment> findAll() {
        return this.feePaymentsRepository.findAll();
    }

    public FeePayment findById(Long paymentId) {
        return this.feePaymentsRepository.findById(paymentId).orElse(null);
    }

    public List<FeePayment> findAllByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        List<CourseEnrollment> courseEnrollmentList = this.courseEnrollmentRepository.findCourseEnrollmentByStudentId(student);
        List<FeePayment> feePaymentList = new ArrayList<>();
        for(CourseEnrollment courseEnrollment: courseEnrollmentList) {
            feePaymentList.addAll(courseEnrollment.getFeePayments());
        }
        return feePaymentList;
    }


    public FeePayment save(FeePayment feePayment) {
        return this.feePaymentsRepository.save(feePayment);
    }
}
