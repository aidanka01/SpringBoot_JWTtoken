package com.example.springbootproject.service.impl;

import com.example.springbootproject.config.jwt.JwtUtil;
import com.example.springbootproject.dto.request.AuthRequest;
import com.example.springbootproject.dto.response.AuthResponse;
import com.example.springbootproject.model.entity.Role;
import com.example.springbootproject.model.entity.User;
import com.example.springbootproject.repository.UserRepository;
import com.example.springbootproject.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    public AuthResponse returnToken(AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()));
        System.out.println(2);
        String generateToken = jwtUtil.generateToken(authentication);

        User user = userRepository.findByEmail(authRequest.getEmail());
        System.out.println(3);
        List<Role> roles = user.getAuth().getRoles();
        String role = String.valueOf(roles.get(0));
        System.out.println(4);
        return new AuthResponse(
                user.getEmail(),
                role,
                generateToken
        );
    }
}
