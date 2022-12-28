
package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.UserRequest;
import com.example.springbootproject.dto.response.UserResponse;
import com.example.springbootproject.model.entity.User;

import java.util.List;

public interface UserService {
    UserResponse save(UserRequest userRequest);

  //  User save(User user);

    UserResponse findById(Long id);

    List<UserResponse> findAll();

    void delete(Long id);


    UserResponse update(Long id, UserRequest userRequest);
}

