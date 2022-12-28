package com.example.springbootproject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String courseName;
    private String duration;
    private Long companyId;
  //  private Long groupId;
}
