package com.example.springbootproject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
}
