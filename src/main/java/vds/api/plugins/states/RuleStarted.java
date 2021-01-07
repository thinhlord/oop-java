package vds.api.plugins.states;

import vds.api.RulePluginEngine;
import vds.api.RuleEngineState;

public class RuleStarted implements RuleEngineState {
    @Override
    public State getState() {
        return State.STARTED;
    }

    @Override
    public void bindingPlugin(RulePluginEngine pluginEngine) {
        //
    }
}
