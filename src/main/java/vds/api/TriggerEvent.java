package vds.api;

import java.util.Map;

public class TriggerEvent {
    String name;
    Map<String, Object> properties;

    Profile profile;

    public TriggerEvent(String name, Map<String, Object> properties, Profile profile) {
        this.name = name;
        this.properties = properties;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Profile getProfile() {
        return profile;
    }
}
