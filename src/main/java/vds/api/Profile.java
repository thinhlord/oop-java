package vds.api;

import java.util.Map;

public class Profile {
   Map<String, Object> properties;

    public Profile(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
}
