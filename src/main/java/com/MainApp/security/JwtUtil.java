package com.MainApp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 256-bit secure key
    private final Key SECRET_KEY = Keys.hmacShaKeyFor(
            "mySuperSecureSecretKeyForJwtAuthentication12345".getBytes()
    );

    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    // Generate Token
    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract UserName
    public String extractUsername(String token) {

        return extractAllClaims(token).getSubject();
    }

    // Extract Role
    public String extractRole(String token) {

        return (String) extractAllClaims(token).get("role");
    }

    // Validate Token
    public boolean validateToken(String token, String username) {

        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // Check expiration
    private boolean isTokenExpired(String token) {

        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // Extract all claims
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}