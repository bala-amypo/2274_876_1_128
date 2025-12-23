package com.example.demo.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.entity.UserAccount;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    // 🔐 Hardcoded secret (min 32 chars)
    private static final String SECRET =
            "MyJwtSecretKeyMyJwtSecretKey123456";

    private static final long EXPIRATION = 3600000; // 1 hour

    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // ✅ Generate token
    public String generateToken(UserAccount user) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
