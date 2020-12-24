package vds.service.visitor;

import vds.service.events.TriggerEvent;
import vds.service.policy.PolicyCondition;

public class EventVisitor implements ConditionVisitor {
    private TriggerEvent triggerEvent;

    public EventVisitor(TriggerEvent triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    @Override
    public void visit(PolicyCondition condition) {
        if (condition.qualifiedEvent(triggerEvent)) System.out.println(condition.getId());
    }
}
