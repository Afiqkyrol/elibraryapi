package com.example.elibrary.service;

import com.example.elibrary.entity.User;
import com.example.elibrary.model.AuthenticationResponse;
import com.example.elibrary.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public AuthenticationResponse register(User request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setFullName(request.getFullName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole_id(request.getRole_id());
        user.setApproved("no");
        user.setAddress1(request.getAddress1());
        user.setAddress2(request.getAddress2());
        user.setApprovedBy("");
        user.setEmail(request.getEmail());
        user.setPhoneNo(request.getPhoneNo());
        user.setRegDate(new Date());
        user.setState(request.getState());
        user.setRole(request.getRole());

        user = userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token, user.getAuthorities(), user.getUsername(), user.getId(), user.getFullName());
    }

    public void adminRegister(User request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setFullName(request.getFullName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole_id(request.getRole_id());
        user.setApproved("yes");
        user.setAddress1(request.getAddress1());
        user.setAddress2(request.getAddress2());
        user.setApprovedBy(request.getApprovedBy());
        user.setApprovedDate(new Date());
        user.setEmail(request.getEmail());
        user.setPhoneNo(request.getPhoneNo());
        user.setRegDate(new Date());
        user.setState(request.getState());
        user.setRole(request.getRole());

        userRepository.save(user);

    }

    public AuthenticationResponse authenticate(User request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token, user.getAuthorities(), user.getUsername(), user.getId(), user.getFullName());
    }
}
