package com.example.springbootproject.controller;

import com.example.springbootproject.dto.request.InstructorRequest;
import com.example.springbootproject.dto.response.InstructorResponse;
import com.example.springbootproject.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/instructor")

public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping()
    public InstructorResponse save(@RequestBody InstructorRequest instructorRequest){
        return instructorService.save(instructorRequest);
    }

    @GetMapping("{id}")
    public InstructorResponse findById(@PathVariable Long id){
        return instructorService.findById(id);
    }

    @GetMapping
    public List<InstructorResponse> findAll(){
        return instructorService.findAll();
    }

    @PutMapping("{id}")
    public InstructorResponse update(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) {
        return instructorService.update(id, instructorRequest);
    }
        @DeleteMapping("{id}")
                public String delete(@PathVariable Long id){
        instructorService.delete(id);
        return String.format(" Instructor with %d id successfully deleted!", id);

        }
    }

