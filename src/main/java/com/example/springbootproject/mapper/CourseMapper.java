package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.response.CourseResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Company;
import com.example.springbootproject.model.entity.Course;
import com.example.springbootproject.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping
public class CourseMapper {
    private final CompanyRepository companyRepository;

    public Course mapToEntity(CourseRequest courseRequest) {
        Course course = new Course();
        Company company = companyRepository.findById(courseRequest.getCompanyId()).get();
        course.setCompany(company);
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        return course;
    }

    public CourseResponse mapToResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();
        if (course.getId() == null) {
            throw new NotFoundException(
                    String.format("Course with %d id not found!", course.getId())
            );
        }
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setCompanyId(course.getCompany().getId()
        );
        return courseResponse;
    }

    public List<CourseResponse> mapToResponse(List<Course> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            courseResponses.add(mapToResponse(course));
        }
        return courseResponses;
    }
}

