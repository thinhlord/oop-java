package vds.spi;

public interface ConditionVisitor<P extends PolicyCondition> {
    void visit(P condition);

    public interface AcceptVisitor {//BooleanCondition
        boolean accept(ConditionVisitor visitor);
    }
}
