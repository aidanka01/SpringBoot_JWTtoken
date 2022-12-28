package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse save(CourseRequest courseRequest);

    CourseResponse findById(Long id);

   List <CourseResponse>  findAll();

   CourseResponse update (Long id, CourseRequest courseRequest);

   void delete (Long  id);
}
