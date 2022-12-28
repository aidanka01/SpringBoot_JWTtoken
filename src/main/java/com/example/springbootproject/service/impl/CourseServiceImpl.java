package com.example.springbootproject.service.impl;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.response.CourseResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Course;
import com.example.springbootproject.mapper.CourseMapper;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse save(CourseRequest courseRequest) {

        return courseMapper.mapToResponse(
                courseRepository.save(
                        courseMapper.mapToEntity(courseRequest)
                )
        );
    }

    @Override
    public CourseResponse findById(Long id) {
        return courseMapper.mapToResponse(getObject(id));
    }

    @Override
    public List<CourseResponse> findAll() {
        return courseMapper.mapToResponse(
                courseRepository.findAll()
        );
    }

    @Override
    public CourseResponse update(Long id, CourseRequest courseRequest) {
       Course course = getObject(id);
       course.setCourseName(courseRequest.getCourseName());
       course.setDuration(courseRequest.getDuration());

       courseRepository.save(course);

        return courseMapper.mapToResponse(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);

    }

    private Course getObject(Long id){
        return courseRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Course with %d id not found!", id)));
    }
}
