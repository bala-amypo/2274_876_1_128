package com.example.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserAccount;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

   
    private static final String DEFAULT_SECRET =
            "MyJwtSecretKeyMyJwtSecretKey123456";
    private static final long DEFAULT_VALIDITY = 3600000;

    private final SecretKey secretKey;
    private final long validityInMs;

    // ✅ REQUIRED BY TEST SUITE
    public JwtUtil(String secret, long validityInMs) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
    }

    // ✅ REQUIRED FOR SPRING (uses defaults)
    public JwtUtil() {
        this(DEFAULT_SECRET, DEFAULT_VALIDITY);
    }

    public String generateToken(UserAccount user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole().name())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public boolean validateToken(String token) {
        getClaims(token); // throws exception if invalid
        return true;
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
