package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.request.StudentRequest;
import com.example.springbootproject.dto.response.StudentResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Student;
import com.example.springbootproject.model.enums.StudyFormat;
import com.example.springbootproject.mapper.StudentMapper;
import com.example.springbootproject.repository.StudentRepository;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        return studentMapper.mapToResponse(
                studentRepository.save(
                        studentMapper.mapToEntity(
                                studentRequest
                        )
                )
        );
    }

    @Override
    public StudentResponse findById(Long id) {
        return studentMapper.mapToResponse(getObject(id));
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentMapper.mapToResponse(
                studentRepository.findAll());
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
       Student student = getObject(id);
       student.setFirstName(studentRequest.getFirstName());
       student.setLastName(studentRequest.getLastName());
       student.setEmail(studentRequest.getEmail());
       student.setStudyFormat(StudyFormat.valueOf(studentRequest.getStudyFormat()));

       studentRepository.save(student);
        return studentMapper.mapToResponse(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }
    private Student getObject(Long id){
        return studentRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Company with %d id not found!", id)));
    }
}
