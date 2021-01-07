package vds.api.model;

import vds.api.TriggerEvent;
import vds.spi.ConditionVisitor;
import vds.spi.PolicyCondition;

import java.util.Map;

public class Policy {
    PolicyCondition[] conditions;

    Map<String, Integer> counting;
    public Policy(PolicyCondition[] conditions) {
        this.conditions = conditions;
    }

    public void handleEvent(TriggerEvent event) {
        counting = this.counting;
        EventVisitor visitor = new EventVisitor(event);
        for (PolicyCondition condition : this.conditions) {
            visitor.visit(condition);
            montorCondition(condition1 -> counting.put(condition1.getId(), counting.get(condition1.getId()) + 1), condition);
        }
    }
    private void montorCondition(ConditionVisitor visitor, PolicyCondition con) {
        visitor.visit(con);
    }
}
