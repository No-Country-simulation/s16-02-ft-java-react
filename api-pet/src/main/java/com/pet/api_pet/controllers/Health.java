package com.pet.api_pet.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/health")
public class Health {

    @GetMapping
    public ResponseEntity<Map<String, Date>> healthcheck() {
        Map<String, Date> resp = new HashMap<>();
        resp.put("timestamp", new Date());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("protected")
    public ResponseEntity<Map<String, Date>> healthcheckProtected() {
        Map<String, Date> resp = new HashMap<>();
        resp.put("timestamp", new Date());
        return ResponseEntity.ok(resp);
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @GetMapping("protected/shelter")
    public ResponseEntity<Map<String, Date>> healthcheckProtectedShelter() {
        Map<String, Date> resp = new HashMap<>();
        resp.put("timestamp", new Date());
        return ResponseEntity.ok(resp);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("protected/admin")
    public ResponseEntity<Map<String, Date>> healthcheckProtectedAdmin() {
        Map<String, Date> resp = new HashMap<>();
        resp.put("timestamp", new Date());
        return ResponseEntity.ok(resp);
    }
}