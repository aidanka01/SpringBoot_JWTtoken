package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.mapper.CompanyMapper;
import com.example.springbootproject.model.entity.Company;
import com.example.springbootproject.repository.CompanyRepository;
import com.example.springbootproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {

        return companyMapper.mapToResponse(
                companyRepository.save(
                        companyMapper.mapToEntity(
                                companyRequest)));
    }

    @Override
    public CompanyResponse findById(Long id) {
        return companyMapper.mapToResponse(getObject(id));

    }

    @Override
    public List<CompanyResponse> findAll() {
        return companyMapper.mapToResponse(
                companyRepository.findAll());
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = getObject(id);
        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

        companyRepository.save(company);
                return companyMapper.mapToResponse(company);
    }

    @Override
    public void delete(Long id) {
 companyRepository.deleteById(id);
    }
    private Company getObject(Long id){
        return companyRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Company with %d id not found!", id)));
    }
}
