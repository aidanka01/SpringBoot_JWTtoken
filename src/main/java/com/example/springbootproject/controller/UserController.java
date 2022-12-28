package com.example.springbootproject.controller;


import com.example.springbootproject.dto.request.AuthRequest;
import com.example.springbootproject.dto.request.UserRequest;
import com.example.springbootproject.dto.response.AuthResponse;
import com.example.springbootproject.dto.response.UserResponse;
import com.example.springbootproject.model.entity.User;
import com.example.springbootproject.service.AuthService;
import com.example.springbootproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
  /*  private final UserService userService;

    @PostMapping("/registration")
    public String save (@RequestBody User user){
        userService.save(user);
        return "Successfully saved!";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }
*/
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/registration")
    public UserResponse registration(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
      System.out.println("login");
        return authService.returnToken(authRequest);
    }
}

