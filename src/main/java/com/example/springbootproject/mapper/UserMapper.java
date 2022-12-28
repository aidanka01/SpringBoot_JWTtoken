package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.request.UserRequest;
import com.example.springbootproject.dto.response.UserResponse;
import com.example.springbootproject.model.entity.Auth;
import com.example.springbootproject.model.entity.User;
import com.example.springbootproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final RoleRepository roleRepository;

    public User mapToEntity(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        Auth auth = new Auth();
        auth.setEmail(userRequest.getEmail());
        auth.setPassword(userRequest.getPassword());
        auth.setRoles(Collections.singletonList(roleRepository.findByName("USER")));

        user.setAuth(auth);

        return user;
    }

    public UserResponse mapToResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
              //  user.getPassword()
        );
    }

    public List<UserResponse> mapToResponse(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user: users){
            userResponses.add(mapToResponse(user));
        }
        return userResponses;
    }
}
