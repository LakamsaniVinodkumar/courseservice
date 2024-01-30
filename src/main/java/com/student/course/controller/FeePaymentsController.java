package com.student.course.controller;

import com.student.course.domain.FeePayment;
import com.student.course.domain.Instructor;
import com.student.course.dto.FeePaymentDTO;
import com.student.course.dto.InstructorDTO;
import com.student.course.dto.mapper.FeePaymentMapper;
import com.student.course.service.FeePaymentsService;
import com.student.course.service.InstructorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feepayments")
@Slf4j
public class FeePaymentsController {

    private final FeePaymentsService feePaymentsService;

    public FeePaymentsController(FeePaymentsService feePaymentsService) {
        this.feePaymentsService = feePaymentsService;
    }

    @GetMapping
    public ResponseEntity<List<FeePaymentDTO>> findAll() {
        log.debug("REST request to get a page of instructors");
        List<FeePaymentDTO> instructorList =  FeePaymentMapper.mapFeePaymentToDto(feePaymentsService.findAll());
        return ResponseEntity.ok().body(instructorList);
    }


    @GetMapping("{studentId}")
    public ResponseEntity<List<FeePaymentDTO>> findByStudentId(@PathVariable Long studentId) {
        log.debug("REST request to get a page of instructors");
        List<FeePaymentDTO> instructorList = FeePaymentMapper.mapFeePaymentToDto(feePaymentsService.findAllByStudentId(studentId));
        return ResponseEntity.ok().body(instructorList);
    }

    @PostMapping
    public ResponseEntity<FeePayment> create(@RequestBody FeePayment feePayment) {
        log.debug("REST request to create a page of FeePayment");
        FeePayment feePaymentData = feePaymentsService.save(feePayment);
        return ResponseEntity.ok().body(feePaymentData);
    }


    @PutMapping
    public ResponseEntity<FeePayment> update(@RequestBody FeePaymentDTO feePayment) {
        log.debug("REST request to create a page of FeePayment");
        FeePayment existedFeePayment = feePaymentsService.findById(feePayment.getId());
        existedFeePayment.setFeeStatus(feePayment.getFeeStatus());
        FeePayment feePaymentData = feePaymentsService.save(existedFeePayment);
        return ResponseEntity.ok().body(feePaymentData);
    }
}
