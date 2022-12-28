package com.example.springbootproject.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyResponse {

    private Long id;
    public String name;
    private String locatedCountry;
    private LocalDate createdAt;
}
