package com.aus.multi_tenant.config;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.aus.multi_tenant.service.TenantDatabaseService;

import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class MultitenantConfiguration {

  @Value("${master.db.url}")
  private String masterDbUrl;

  @Value("${master.db.username}")
  private String masterDbUsername;

  @Value("${master.db.password}")
  private String masterDbPassword;

  @Bean
  public DataSource masterDataSource() {
      return DataSourceBuilder.create()
              .url(masterDbUrl)
              .username(masterDbUsername)
              .password(masterDbPassword)
              .driverClassName("com.mysql.cj.jdbc.Driver") // Change for your DB type
              .build();
  }

}