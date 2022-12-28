package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.AuthRequest;
import com.example.springbootproject.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse returnToken(AuthRequest authRequest);
}

