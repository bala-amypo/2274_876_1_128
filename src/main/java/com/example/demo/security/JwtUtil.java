package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    // REQUIRED constructor (PDF rule)
    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // Generate token with claims
    public String generateToken(Long userId, String email, String role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Extract email (subject)
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Extract role
    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    // Check expiry
    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Validate token
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // Parse claims
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
