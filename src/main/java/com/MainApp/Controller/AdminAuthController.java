package com.MainApp.Controller;

import com.MainApp.Entity.Admin;
import com.MainApp.Repository.AdminRepository;
import com.MainApp.security.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AdminAuthController(AdminRepository adminRepository,
                               PasswordEncoder passwordEncoder,
                               AuthenticationManager authenticationManager,
                               JwtUtil jwtUtil) {

        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // REGISTER ADMIN
    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin) {

        if (adminRepository.findByAdminName(admin.getAdminName()).isPresent()) {
            return "Admin already exists!";
        }

        admin.setAdminPass(passwordEncoder.encode(admin.getAdminPass()));
        admin.setAdminRole("ROLE_ADMIN");

        adminRepository.save(admin);

        return "Admin registered successfully!";
    }

    // LOGIN ADMIN
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Admin admin) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        admin.getAdminName(),
                        admin.getAdminPass()
                )
        );

        Admin existingAdmin = adminRepository
                .findByAdminName(admin.getAdminName())
                .orElseThrow();

        String token = jwtUtil.generateToken(
                existingAdmin.getAdminName(),
                existingAdmin.getAdminRole()
        );

        return Map.of("token", token);
    }
}