package com.aus.multi_tenant.config;

public class TenantContext {

  private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();

  // Private constructor to prevent instantiation
  private TenantContext() {
    // Optional: throw an exception if this constructor is invoked
    throw new UnsupportedOperationException("Cannot instantiate TenantContext");
  }

  public static String getCurrentTenant() {
      return CURRENT_TENANT.get();
  }

  public static void setCurrentTenant(String tenant) {
      CURRENT_TENANT.set(tenant);
  }

  // Call this method to clear the ThreadLocal value
  public static void clear() {
    CURRENT_TENANT.remove();
}
}