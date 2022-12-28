package com.example.springbootproject.config.jwt;

import com.example.springbootproject.config.JwtConfig;
import com.example.springbootproject.model.entity.Auth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {


    private final JwtConfig jwtConfig;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

//        Auth auth = (Auth) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtConfig.getExpiration() * 8600000))
                .compact();
    }
//    Auth castTestHa()

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean verifyToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtConfig.getSecretKey())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
