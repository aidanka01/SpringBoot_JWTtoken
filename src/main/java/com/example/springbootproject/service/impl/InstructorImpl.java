package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.request.InstructorRequest;
import com.example.springbootproject.dto.response.InstructorResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Instructor;
import com.example.springbootproject.mapper.InstructorMapper1;
import com.example.springbootproject.repository.InstructorRepository;
import com.example.springbootproject.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class InstructorImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper1 instructorMapper;
    @Override
    public InstructorResponse save(InstructorRequest instructorRequest) {
        return instructorMapper.mapToResponse(
                instructorRepository.save(
                        instructorMapper.mapToEntity(
                                instructorRequest
                        )
                )
        );
    }

    @Override
    public InstructorResponse findById(Long id) {
        return instructorMapper.mapToResponse(getObject(id));
    }

    @Override
    public List<InstructorResponse> findAll() {
        return instructorMapper.mapToResponse(
                instructorRepository.findAll()
        );
    }

    @Override
    public InstructorResponse update(Long id, InstructorRequest instructorRequest) {
      Instructor instructor = getObject(id);
      instructor.setFirstName(instructorRequest.getFirstName());
      instructor.setLastName(instructorRequest.getLastName());
      instructor.setEmail(instructorRequest.getEmail());
     instructorRepository.save(instructor);
        return instructorMapper.mapToResponse(instructor);
    }

    @Override
    public void delete(Long id) {
        instructorRepository.deleteById(id);

    }
    private Instructor getObject(Long id){
        return instructorRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Company with %d id not found!", id)));
    }
}
