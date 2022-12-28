package com.example.springbootproject.controller;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.response.CourseResponse;
import com.example.springbootproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping()
    public CourseResponse save(@RequestBody CourseRequest courseRequest){
        return courseService.save(courseRequest);
    }

    @GetMapping("{id}")
    public CourseResponse findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @PutMapping
    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequest courseRequest){
        return  courseService.update(id, courseRequest);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        courseService.delete(id);
        return String.format("Course with %d id is successfully deleted!", id);
    }
}
