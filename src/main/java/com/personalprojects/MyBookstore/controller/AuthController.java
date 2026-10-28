package com.personalprojects.MyBookstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtEncoder encoder;

    @Value("${admin.password}")
    private String adminPassword;

    public AuthController(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    record LoginRequest(String password) {}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String pw = req.password() == null ? "" : req.password();
        boolean ok = MessageDigest.isEqual(
                adminPassword.getBytes(StandardCharsets.UTF_8),
                pw.getBytes(StandardCharsets.UTF_8));
        if (!ok) {
            return ResponseEntity.status(401).body(Map.of("error", "Contraseña incorrecta"));
        }
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject("admin")
                .issuedAt(now)
                .expiresAt(now.plus(8, ChronoUnit.HOURS))
                .build();
        String token = encoder.encode(
                JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims)
        ).getTokenValue();
        return ResponseEntity.ok(Map.of("token", token));
    }
}
