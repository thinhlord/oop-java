package vds.service.policy;

import vds.service.events.TriggerEvent;

public interface PolicyCondition {
    String getId();
    boolean qualifiedEvent(TriggerEvent event);
}
