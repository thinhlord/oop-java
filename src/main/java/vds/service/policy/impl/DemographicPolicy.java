package vds.service.policy.impl;

import vds.service.events.TriggerEvent;
import vds.service.policy.PolicyCondition;

import java.util.Map;

public class DemographicPolicy implements PolicyCondition {
    private final Map<String, ComparableCondition> comparableConditions;
    private final String id;

    public DemographicPolicy(String id, Map<String, ComparableCondition> comparableConditions) {
        this.comparableConditions = comparableConditions;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean qualifiedEvent(TriggerEvent event) {
        for (Map.Entry<String, ComparableCondition> conditionEntry : comparableConditions.entrySet()) {
            if (event.getProfile().containsKey(conditionEntry.getKey())) {
                boolean compare = conditionEntry.getValue().satisfy(event.getProfile().get(conditionEntry.getKey()));
                if (!compare) return false;
            } else return true;
        }
        return false;
    }
}
