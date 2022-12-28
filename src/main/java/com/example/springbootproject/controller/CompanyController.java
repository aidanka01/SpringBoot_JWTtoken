package com.example.springbootproject.controller;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

  //  @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping()
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest) {
        return companyService.save(companyRequest);
    }


    @GetMapping("{id}")
    public CompanyResponse findById(@PathVariable Long id){

        return companyService.findById(id);
    }

    @GetMapping
   public List<CompanyResponse> findAll(){

        return companyService.findAll();
   }

   @PutMapping("{id}")
   public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest){
        return companyService.update(id, companyRequest);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        companyService.delete(id);
        return String.format("Company with %d id successfully deleted!", id);
    }
}
