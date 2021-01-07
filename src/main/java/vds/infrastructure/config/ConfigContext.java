package vds.infrastructure.config;

public class ConfigContext {
    private int tenantId;

    public ConfigContext(int tenantId) {
        this.tenantId = tenantId;
    }

    int getTenantId() {
        return this.tenantId;
    }
}
