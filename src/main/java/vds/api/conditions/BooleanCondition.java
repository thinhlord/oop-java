package vds.api.conditions;

import vds.api.TriggerEvent;
import vds.api.model.Policy;
import vds.spi.ConditionVisitor;
import vds.spi.PolicyCondition;

import java.util.List;

public class BooleanCondition implements PolicyCondition, ConditionVisitor.AcceptVisitor {
    List<PolicyCondition> conditions;
    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean qualifiedEvent(TriggerEvent event) {
       return false;
    }

    @Override
    public boolean accept(ConditionVisitor visitor) {
        //AcceptVisitor
        for (PolicyCondition con : conditions) {
            visitor.visit(con);
        }
        return true;
    }
}
