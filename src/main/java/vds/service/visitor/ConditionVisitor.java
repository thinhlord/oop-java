package vds.service.visitor;

import vds.service.policy.PolicyCondition;

public interface ConditionVisitor {
    void visit(PolicyCondition condition);
}
