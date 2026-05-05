package edu.kost.opensourcekeycloaklab.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            Object username = jwtAuth.getToken().getClaim("preferred_username");
            return Optional.ofNullable(username != null ? username.toString() : null);
        }

        return Optional.ofNullable(authentication.getName());
    }
}
