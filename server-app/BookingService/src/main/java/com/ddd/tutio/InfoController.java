package com.ddd.tutio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kontroler z punktami dostępowymi sprawdzającymi, czy aplikacja uruchomiła się poprawnie.
 */
@RestController
@RequestMapping
public class InfoController {

    @GetMapping("/health")
    public String healthCheck() {
        return "HEALTH CHECK OK!";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 0.0.1-SNAPSHOT";
    }
}
