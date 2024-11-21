package com.aus.multi_tenant.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@Service
@RequiredArgsConstructor
public class TenantDatabaseService {

    private final DataSource masterDataSource;


    public void createTenantDatabase(String tenantId) throws SQLException {
        try (Connection connection = masterDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS " + tenantId;
            statement.executeUpdate(createDatabaseSql);
            log.info("Database created for tenant: " + tenantId);
        }
    }


}
