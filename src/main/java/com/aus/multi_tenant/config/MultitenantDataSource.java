package com.aus.multi_tenant.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultitenantDataSource extends AbstractRoutingDataSource {

  @Override
  protected String determineCurrentLookupKey() {
      return TenantContext.getCurrentTenant();
  }
}