package com.project.covid19.controllers;

import com.project.covid19.models.Admin;
import com.project.covid19.payload.request.LoginRequest;
import com.project.covid19.payload.request.SignupRequest;
import com.project.covid19.payload.response.JwtResponse;
import com.project.covid19.payload.response.MessageResponse;
import com.project.covid19.repository.AdminRepository;
import com.project.covid19.security.jwt.JwtUtils;
import com.project.covid19.security.services.AdminDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        AdminDetailsImpl userDetails = (AdminDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getNic(),
                userDetails.getUsername()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (adminRepository.existsByNic(signUpRequest.getNic())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Already entered in the database!"));
        }

        // Create new GS's account
        Admin admin = new Admin(signUpRequest.getNic(),signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        adminRepository.save(admin);

        return ResponseEntity.ok(new MessageResponse("GS registered successfully!"));
    }
}
