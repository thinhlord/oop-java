package vds.spi;

import vds.api.TriggerEvent;

public interface PolicyCondition {
    String getId();
    boolean qualifiedEvent(TriggerEvent event);
}
