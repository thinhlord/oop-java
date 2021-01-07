package vds.api.conditions;

import org.junit.Test;
import vds.api.Profile;
import vds.api.TriggerEvent;
import vds.spi.PolicyCondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class DemoGraphicPolicyTest {

    @Test
    public void testQualifiedEvent_With_Single_Properties() {
        Map<String, DemoGraphicPolicy.ComparisonOperator> prop = new ConcurrentHashMap<>();
        prop.put("age", new DemoGraphicPolicy.ComparisonOperator(">", 20));
        PolicyCondition testMe = new DemoGraphicPolicy(prop);

        Map<String, Object> myProfile = new ConcurrentHashMap<>();
        myProfile.put("age", 21);
        TriggerEvent event = new TriggerEvent("hello", null, new Profile(myProfile));
        boolean expected = testMe.qualifiedEvent(event);
        assertTrue(expected);
    }
    @Test
    public void testQualifiedEvent_With_Multiple_Properties() {
        Map<String, DemoGraphicPolicy.ComparisonOperator> prop = new ConcurrentHashMap<>();
        prop.put("age", new DemoGraphicPolicy.ComparisonOperator(">", 20));
        prop.put("location", new DemoGraphicPolicy.ComparisonOperator("==", "Saigon"));
        PolicyCondition testMe = new DemoGraphicPolicy(prop);

        Map<String, Object> myProfile = new ConcurrentHashMap<>();
        myProfile.put("age", 21);
        myProfile.put("location", "Saigon");
        TriggerEvent event = new TriggerEvent("hello", null, new Profile(myProfile));
        boolean expected = testMe.qualifiedEvent(event);
        assertTrue(expected);
    }
}