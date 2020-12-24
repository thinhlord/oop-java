package vds.service.policy;

import vds.service.events.TriggerEvent;
import vds.service.visitor.EventVisitor;

import java.util.List;

public class Policy {
    private final List<PolicyCondition> conditions;

    public Policy(List<PolicyCondition> conditions) {
        this.conditions = conditions;
    }

    void handleEvent(TriggerEvent event) {
        EventVisitor visitor = new EventVisitor(event);
        for (PolicyCondition condition: conditions) visitor.visit(condition);
    }
}
