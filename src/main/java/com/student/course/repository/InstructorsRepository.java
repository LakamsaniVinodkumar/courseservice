package com.student.course.repository;

import com.student.course.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorsRepository  extends JpaRepository<Instructor, Long> {
}