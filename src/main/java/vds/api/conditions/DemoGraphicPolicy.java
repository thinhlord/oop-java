package vds.api.conditions;

import vds.api.TriggerEvent;
import vds.spi.PolicyCondition;

import java.util.Map;

public class DemoGraphicPolicy implements PolicyCondition {
    public static class ComparisonOperator {
        String operator;
        Object value;

        public ComparisonOperator(String operator, Object value) {
            this.operator = operator;
            this.value = value;
        }

        boolean eval(Object value) {
            if (value instanceof Integer) {
                return this.compareInt((Integer) this.value, (Integer) value);
            }
            if (value instanceof String) {
                return this.compareString((String) this.value, (String) value);
            }
            return false;
        }

        boolean compareString(String expected, String value) {
            switch (operator) {
                case ">":
                    return value.compareTo(expected) > 0;
                case "==":
                    return value.compareTo(expected) == 0;
            }
            return false;
        }

        boolean compareInt(Integer expected, Integer value) {
            switch (operator) {
                case ">":
                    return value > expected;
                case "==":
                    return value.equals(expected);
            }
            return false;
        }
    }

    Map<String, ComparisonOperator> properties;

    public DemoGraphicPolicy(Map<String, ComparisonOperator> properties) {
        this.properties = properties;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean qualifiedEvent(TriggerEvent event) {
        for (Map.Entry<String, ComparisonOperator> entry : this.properties.entrySet()) {
            boolean current = entry.getValue().eval(event.getProfile().getProperties().get(entry.getKey()));
            if (!current) {
                return false;
            }
        }
        return true;
    }
}
