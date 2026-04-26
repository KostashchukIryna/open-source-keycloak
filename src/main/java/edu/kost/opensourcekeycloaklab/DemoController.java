package edu.kost.opensourcekeycloaklab;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
    @GetMapping("/user")
    @PreAuthorize("hasRole('client_user')")
    public String userAccess() {
        return "Hello user!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('client_admin')")
    public String adminAccess() {
        return "Hello admin!";
    }

    @GetMapping("/public")
    public String anonymousAccess() {
        return "Hello from an anonymous endpoint!";
    }
}
