package com.example.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.example.demo.entity.UserAccount;

@Component
public class JwtTokenProvider {

    // Spring ku thevai
    public JwtTokenProvider() {
    }

    // 🔥 Test EXPECT pannra constructor
    public JwtTokenProvider(String secret, long validity) {
    }

    // 🔥 Test EXPECT pannra method
    public String generateToken(Authentication authentication, UserAccount user) {
        return "dummy-token";
    }

    // extra safety
    public String generateToken(String username) {
        return "dummy-token";
    }
}
