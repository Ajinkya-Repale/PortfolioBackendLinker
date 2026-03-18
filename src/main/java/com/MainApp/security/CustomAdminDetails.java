package com.MainApp.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.MainApp.Entity.Admin;

public class CustomAdminDetails implements UserDetails {

    private Admin admin;

    public CustomAdminDetails(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = admin.getAdminRole();

        // Spring's .hasRole("ADMIN") internally checks for "ROLE_ADMIN"
        // If DB stores "ADMIN" → we add the prefix
        // If DB already stores "ROLE_ADMIN" → we use it as-is (no double prefix)
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return admin.getAdminPass();
    }

    @Override
    public String getUsername() {
        return admin.getAdminName();
    }

    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled()               { return true; }

    public Admin getAdmin() {
        return this.admin;
    }
}