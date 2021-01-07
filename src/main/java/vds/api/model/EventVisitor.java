package vds.api.model;

import vds.api.TriggerEvent;
import vds.api.conditions.BooleanCondition;
import vds.spi.ConditionVisitor;
import vds.spi.PolicyCondition;

public class EventVisitor implements ConditionVisitor {

    TriggerEvent event;

    public EventVisitor(TriggerEvent event) {
        this.event = event;
    }

    @Override
    public void visit(PolicyCondition condition) {
        if (condition instanceof AcceptVisitor) {
                ((AcceptVisitor) condition).accept(this);         //for)loop
        }
        boolean result = condition.qualifiedEvent(this.event);

        boolean profileValid = false;
    }
}
