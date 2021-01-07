package vds.api.plugins;

import vds.api.RuleEngineState;
import vds.api.RulePluginEngine;
import vds.api.plugins.states.RuleFailed;
import vds.api.plugins.states.RuleStarted;

public class RuleMonitor implements RulePluginEngine {
    @Override
    public String name() {
        return "monitor";
    }

    @Override
    public void onStateChange(RuleEngineState.State state) {
        switch (state) {
            case STARTED:
                RuleEngineState trigger = new RuleStarted();
                trigger.bindingPlugin(this);
            case FAILED:
                RuleEngineState newState = new RuleFailed();
                newState.bindingPlugin(this);
        }
    }
}
