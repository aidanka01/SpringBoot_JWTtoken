package com.example.springbootproject.controller;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.response.CompanyResponse;
import com.example.springbootproject.dto.response.StudentResponse;
import com.example.springbootproject.mapper.StudentMapper;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/student")

public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public StudentResponse save(@RequestBody StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }

    @GetMapping("{id}")
    public StudentResponse findById(@PathVariable Long id){

        return studentService.findById(id);
    }

    @GetMapping
    public List<StudentResponse> findAll(){

        return studentService.findAll();
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        studentService.delete(id);
        return String.format("Student with %d id successfully deleted!", id);
    }
}



