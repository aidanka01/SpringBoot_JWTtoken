package com.example.springbootproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String studyFormat;
    private Long groupId;
}
