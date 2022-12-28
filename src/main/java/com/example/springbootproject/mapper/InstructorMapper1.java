package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.InstructorRequest;
import com.example.springbootproject.dto.response.InstructorResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Course;
import com.example.springbootproject.model.entity.Instructor;
import com.example.springbootproject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping
public class InstructorMapper1 {
    private final CourseRepository courseRepository;

    public Instructor mapToEntity(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        Course course = courseRepository.findById(instructorRequest.getCourseId()).get();
        instructor.setCourse(course);
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());

        return instructor;
    }

    public InstructorResponse mapToResponse(Instructor instructor) {
        InstructorResponse instructorResponse = new InstructorResponse();
        if (instructor.getId() == null) {
            throw new NotFoundException(
                    String.format("Company with %d id not found", instructor.getId())
            );
        }
        instructorResponse.setId(instructor.getId());
        instructorResponse.setFirstName(instructor.getFirstName());
        instructorResponse.setLastName(instructor.getLastName());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setCourseId(instructor.getCourse().getId());
        return instructorResponse;
    }

    public List<InstructorResponse> mapToResponse(List<Instructor> instructors) {
        List<InstructorResponse> instructorResponses = new ArrayList<>();
        for (Instructor instructor : instructors) {
            instructorResponses.add(mapToResponse(instructor));
        }
        return instructorResponses;
    }
}


