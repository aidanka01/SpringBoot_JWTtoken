package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse save( StudentRequest studentRequest);

    StudentResponse findById(Long id);

    List <StudentResponse> findAll();

    StudentResponse update(Long id,  StudentRequest studentRequest);

    void  delete(Long id);
}
