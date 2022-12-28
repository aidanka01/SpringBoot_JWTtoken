package com.example.springbootproject.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CatServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        Cat cat = new Cat();
        cat.name = "musya";
        cat.pass = "$2a$12$pz7/BXVvHmAifIEP3uaJpeyu0.VpRrhfm/3sCYbIRV3agLyvVvHe6";
        Color color = new Color();
        color.name = "black";
        cat.color =color;
        System.out.println("searching in database");
        //
        System.out.println("find cat ");
        return cat;
    }
}

class Cat implements UserDetails {
    String name;
    String pass;

    Color color;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> sdf = new ArrayList<>();
        sdf.add(color);
        return sdf;
    }

    @Override
    public String getPassword() {
        return pass+"";
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
class Color implements GrantedAuthority{
    String name;

    @Override
    public String getAuthority() {
        return name;
    }
}