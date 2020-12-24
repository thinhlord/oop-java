package vds.service.policy.impl;

import java.util.HashMap;
import java.util.Map;

public class ComparableCondition {
    enum Operator {
        GT(">"),
        LT("<"),
        EQ("="),
        GE(">="),
        LE("<="),
        DF("<>");

        private static final Map<String, Operator> stringToOps = new HashMap<>();

        static {
            for (Operator o : Operator.values()) {
                stringToOps.put(o.operator, o);
            }
        }

        private String operator;

        Operator(String operator) {
            this.operator = operator;
        }

        static Operator from(String operator) {
            return stringToOps.get(operator);
        }
    }

    private final Comparable value;
    private final Operator operator;

    public ComparableCondition(Operator operator, int value) {
        this.value = value;
        this.operator = operator;
    }

    public ComparableCondition(String operator, int value) {
        this.value = value;
        this.operator = Operator.from(operator);
    }

    public boolean satisfy(Comparable compareValue) {
        int compareResult = compareValue.compareTo(value);
        switch (operator) {
            case DF:
                return compareResult != 0;
            case GT:
                return compareResult > 0;
            case LE:
                return compareResult <= 0;
            case LT:
                return compareResult < 0;
            case EQ:
                return compareResult == 0;
            case GE:
                return compareResult >= 0;
            default:
                return false;
        }
    }
}
