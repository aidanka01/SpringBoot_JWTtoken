package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.request.InstructorRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.dto.response.InstructorResponse;

import java.util.List;

public interface InstructorService {
    InstructorResponse save(InstructorRequest instructorRequest);

    InstructorResponse findById(Long id);

    List<InstructorResponse> findAll();

    InstructorResponse update(Long id, InstructorRequest instructorRequest);

    void  delete(Long id);
}
