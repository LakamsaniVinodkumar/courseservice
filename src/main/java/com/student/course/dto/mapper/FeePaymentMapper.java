package com.student.course.dto.mapper;

import com.student.course.domain.CourseEnrollment;
import com.student.course.domain.FeePayment;
import com.student.course.domain.Instructor;
import com.student.course.dto.FeePaymentDTO;
import com.student.course.dto.InstructorDTO;

import java.util.ArrayList;
import java.util.List;

public class FeePaymentMapper {


    public static FeePaymentDTO mapFeePaymentToDto(FeePayment feePayment) {
        FeePaymentDTO feePaymentDTO = new FeePaymentDTO();
        if(feePayment!=null) {
            feePaymentDTO.setCourseId(CourseMapper.mapCourseToDto(feePayment.getEnrollId().getCourseId()));
            feePaymentDTO.setStudentId(StudentMapper.mapStudentToDto(feePayment.getEnrollId().getStudentId()));
            feePaymentDTO.setId(feePayment.getId());
            feePaymentDTO.setFeeStatus(feePayment.getFeeStatus());
            feePaymentDTO.setFeeAmount(feePayment.getFeeAmount());
        }
        return feePaymentDTO;
    }

    public static List<FeePaymentDTO> mapFeePaymentToDto(List<FeePayment> feePayments) {
        List<FeePaymentDTO> feePaymentDTOList = new ArrayList<>();
        for(FeePayment feePayment: feePayments) {
            feePaymentDTOList.add(mapFeePaymentToDto(feePayment));
        }
        return feePaymentDTOList;
    }


    public static FeePayment mapFeePayment(FeePaymentDTO feePaymentDTO) {
        FeePayment feePayment = new FeePayment();
       // CourseEnrollment enrollId= new CourseEnrollment();
       // enrollId.setCourseId(CourseMapper.mapCourseDtoToCourse(feePaymentDTO.getCourseId()));
       // enrollId.setStudentId(StudentMapper.mapStudent(feePaymentDTO.getStudentId()));
        feePayment.setFeeAmount(feePaymentDTO.getFeeAmount());
        feePayment.setFeeStatus(feePaymentDTO.getFeeStatus());
        feePayment.setId(feePaymentDTO.getId());
       // feePayment.setEnrollId(enrollId);
        return feePayment;
    }
}
