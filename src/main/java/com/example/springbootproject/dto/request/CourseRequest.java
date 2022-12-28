package com.example.springbootproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    private String courseName;
    private String duration;
    private Long companyId;
  //  private Long groupId;
}
