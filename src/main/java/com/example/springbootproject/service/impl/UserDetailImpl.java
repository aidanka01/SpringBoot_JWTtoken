package com.example.springbootproject.service.impl;


import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.model.entity.Role;


import com.example.springbootproject.model.entity.User;
import com.example.springbootproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String sdfsdf) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(sdfsdf);

        if (user == null){
            throw new NotFoundException(String.format("User with %s user name not found!", sdfsdf));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRoleToAuthority(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<Role> roles){
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }





}

/*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }*//*

}
*/
