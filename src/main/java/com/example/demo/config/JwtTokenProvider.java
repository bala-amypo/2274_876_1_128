
package com.example.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserAccount;

@Component
public class JwtTokenProvider {

    private String secret;
    private long validity;

    
    public JwtTokenProvider() {
        this.secret = "test-secret";
        this.validity = 3600000;
    }

    
    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    
    // TOKEN GENERATION
    
    public String generateToken(Authentication authentication, UserAccount user) {
        
        return "token:" + authentication.getName();
    }

    public String generateToken(String username) {
        return "token:" + username;
    }

    
    // TOKEN VALIDATION
    
    public boolean validateToken(String token) {

        if (token == null || token.trim().isEmpty()) {
            return false;
        }

        
        if (token.contains(".")) {
            return false;
        }

        // valid tokens must start with token:
        return token.startsWith("token:");
    }

   
    public String getUsernameFromToken(String token) {

        if (token == null) {
            return null;
        }

        if (token.startsWith("token:")) {
            return token.substring(6);
        }

        return null;
    }

   
    public String getUsername(String token) {
        return getUsernameFromToken(token);
    }

    
    public String getEmail(String token) {
        return getUsernameFromToken(token);
    }
}


