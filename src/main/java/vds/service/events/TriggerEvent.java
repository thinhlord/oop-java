package vds.service.events;

import java.util.Map;

public class TriggerEvent {
    private String name;
    private Map<String, ? extends Comparable> profile;

    public TriggerEvent(String name, Map<String, ? extends Comparable> profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ? extends Comparable> getProfile() {
        return profile;
    }

    public void setProfile(Map<String, ? extends Comparable> profile) {
        this.profile = profile;
    }
}
