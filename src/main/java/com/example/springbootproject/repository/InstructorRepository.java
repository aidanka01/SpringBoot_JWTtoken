package com.example.springbootproject.repository;

import com.example.springbootproject.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
