package com.emirhan.portfolio.auth;

import com.emirhan.portfolio.config.JwtUtil;
import com.emirhan.portfolio.user.User;
import com.emirhan.portfolio.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest request){
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("Username not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }



}
