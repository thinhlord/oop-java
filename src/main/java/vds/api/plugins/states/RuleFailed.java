package vds.api.plugins.states;

import vds.api.RulePluginEngine;
import vds.api.RuleEngineState;

public class RuleFailed implements RuleEngineState {
    @Override
    public State getState() {
        return State.FAILED;
    }

    @Override
    public void bindingPlugin(RulePluginEngine pluginEngine) {
        // do something when failed
    }
}
