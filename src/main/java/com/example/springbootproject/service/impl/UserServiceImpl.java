package com.example.springbootproject.service.impl;



import com.example.springbootproject.dto.request.UserRequest;
import com.example.springbootproject.dto.response.UserResponse;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.mapper.UserMapper;
import com.example.springbootproject.model.entity.User;
import com.example.springbootproject.repository.UserRepository;
import com.example.springbootproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse save(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userMapper.mapToResponse(
                userRepository.save(
                        userMapper.mapToEntity(userRequest)));
    }
        @Override
        public UserResponse findById(Long id) {
            return userMapper.mapToResponse(getObject(id));

        }
        @Override
        public List<UserResponse> findAll() {
            return userMapper.mapToResponse(
                    userRepository.findAll());
        }

        @Override
        public void delete(Long id) {
             userRepository.deleteById(id);

        }

        @Override
        public UserResponse update(Long id, UserRequest userRequest) {
        User user = getObject(id);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
       userRepository.save(user);
        return userMapper.mapToResponse(user);
        }
    private User getObject(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new NotFoundException(
                        String.format("Company with %d id not found!", id)));
    }
    }

   /* private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User save(User user) {


        if (user.getName().equals("meder")) {
            user.setRoles(
                    Collections.singleton(
                            new Role("ADMIN"))
            );
        } else {
            if (roleRepository.existsByName("USER"))
                user.setRoles(
                        Collections.singleton(
                                roleRepository.findByName("USER")
                        ));
            else {
                user.setRoles(Collections.singleton(
                        new Role("USER")));
            }
        }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
*/



