package com.MainApp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomAdminDetailsService adminDetailsService;

    // ── Public paths that never need a token ──────────────────────────────────
    private static final List<String> PUBLIC_PATHS = List.of(
        "/hero/all",
        "/skills/all",
        "/projects/all",
        "/about/all",
        "/contact/all",
        "/admin/auth/login",
        "/admin/auth/register"
    );

    public JwtFilter(JwtUtil jwtUtil, CustomAdminDetailsService adminDetailsService) {
        this.jwtUtil = jwtUtil;
        this.adminDetailsService = adminDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // ── Step 1: Skip JWT processing entirely for public endpoints ──────────
        // Without this, a missing/null token causes an exception that
        // results in a 403 even though SecurityConfig has .permitAll() on them.
        if (isPublicPath(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        // ── Step 2: Extract Authorization header ───────────────────────────────
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // No token — let Spring Security handle it (will 401/403 if required)
            filterChain.doFilter(request, response);
            return;
        }

        // ── Step 3: Validate token and set authentication ──────────────────────
        String token = authHeader.substring(7);

        try {
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = adminDetailsService.loadUserByUsername(username);

                if (jwtUtil.validateToken(token, userDetails.getUsername())) {
                    UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                        );
                    authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (Exception e) {
            // Invalid/expired token — clear context and continue
            // Spring Security will reject the request if the endpoint needs auth
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

    // ── Helper: check if request path matches any public path ─────────────────
    private boolean isPublicPath(String requestPath) {
        return PUBLIC_PATHS.stream().anyMatch(requestPath::equals);
    }
}