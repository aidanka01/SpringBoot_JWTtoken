package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CourseRequest;
import com.example.springbootproject.dto.request.GroupRequest;
import com.example.springbootproject.dto.response.CourseResponse;
import com.example.springbootproject.dto.response.GroupResponse;

import java.util.List;

public interface GroupService {

    GroupResponse save(GroupRequest groupRequest);

    GroupResponse findById(Long id);

    List<GroupResponse> findAll();

   GroupResponse update (Long id, GroupRequest groupRequest);

    void delete (Long  id);
}

