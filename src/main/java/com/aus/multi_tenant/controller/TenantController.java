package com.aus.multi_tenant.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.multi_tenant.service.TenantDatabaseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tenant")
public class TenantController {

    private final TenantDatabaseService tenantDatabaseService;


    @PostMapping("/create/{tenantId}")
    public ResponseEntity<String> createTenant(@PathVariable String tenantId) {
        try {
            tenantDatabaseService.createTenantDatabase(tenantId);
            return ResponseEntity.ok("Tenant " + tenantId + " created successfully.");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating tenant: " + e.getMessage());
        }
    }
}

