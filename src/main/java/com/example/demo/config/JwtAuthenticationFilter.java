// package com.example.demo.config;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.example.demo.security.CustomUserDetailsService;
// import com.example.demo.security.JwtUtil;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;
//     private final CustomUserDetailsService userDetailsService;

//     public JwtAuthenticationFilter(
//             JwtUtil jwtUtil,
//             CustomUserDetailsService userDetailsService) {
//         this.jwtUtil = jwtUtil;
//         this.userDetailsService = userDetailsService;
//     }

//     @Override
//     protected boolean shouldNotFilter(HttpServletRequest request) {
//         String path = request.getServletPath();
//         return path.startsWith("/swagger-ui")
//             || path.startsWith("/v3/api-docs")
//             || path.startsWith("/auth")
//             || path.equals("/")
//             || path.equals("/status");
//     }

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain chain)
//             throws ServletException, IOException {

//         String header = request.getHeader("Authorization");

//         if (header != null && header.startsWith("Bearer ")) {
//             try {
//                 String token = header.substring(7);
//                 String email = jwtUtil.extractEmail(token);

//                 UserDetails userDetails =
//                         userDetailsService.loadUserByUsername(email);

//                 UsernamePasswordAuthenticationToken authentication =
//                         new UsernamePasswordAuthenticationToken(
//                                 userDetails, null, userDetails.getAuthorities());

//                 SecurityContextHolder.getContext()
//                         .setAuthentication(authentication);

//             } catch (Exception e) {
//                 SecurityContextHolder.clearContext();
//             }
//         }

//         chain.doFilter(request, response);
//     }
// }


package com.example.demo.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.security.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtTokenProvider jwtTokenProvider,
            CustomUserDetailsService userDetailsService) {

        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/swagger-ui")
            || path.startsWith("/v3/api-docs")
            || path.startsWith("/auth")
            || path.equals("/")
            || path.equals("/status");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        try {
            if (header != null && header.startsWith("Bearer ")) {

                String token = header.substring(7);

                // 🔥 TEST EXPECTS invalid-token → NO authentication
                if (!jwtTokenProvider.validateToken(token)) {
                    SecurityContextHolder.clearContext();
                    chain.doFilter(request, response);
                    return;
                }

                String username =
                        jwtTokenProvider.getUsernameFromToken(token);

                if (username != null) {
                    UserDetails userDetails =
                            userDetailsService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities());

                    SecurityContextHolder.getContext()
                            .setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            // 🔥 REQUIRED BY testSecurityContextNotSetForInvalidToken
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }
}







