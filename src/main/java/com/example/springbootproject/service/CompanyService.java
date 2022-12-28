package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse save(CompanyRequest companyRequest);

    CompanyResponse findById(Long id);

    List<CompanyResponse> findAll();
    CompanyResponse update(Long id, CompanyRequest companyRequest);

    void  delete(Long id);
}
