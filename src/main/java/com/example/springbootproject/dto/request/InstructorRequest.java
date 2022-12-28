package com.example.springbootproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
}
