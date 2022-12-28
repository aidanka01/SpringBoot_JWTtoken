package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping
public class CompanyMapper {
    public Company mapToEntity(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        company.setCreatedAt(LocalDate.now());

        return company;
    }

    public CompanyResponse mapToResponse(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        if (company.getId() == null) {
            throw new NotFoundException(
                    String.format("Company with %d id not found", company.getId())
            );
        }
        companyResponse.setId(company.getId());
        companyResponse.setName(company.getName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setCreatedAt(company.getCreatedAt());
        return companyResponse;
    }

    public List<CompanyResponse> mapToResponse(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company company : companies) {
            companyResponses.add(mapToResponse(company));
        }
        return companyResponses;
    }


}
