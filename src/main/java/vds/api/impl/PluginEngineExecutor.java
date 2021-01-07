package vds.api.impl;

import vds.api.RulePluginEngine;
import vds.api.RuleEngineState;

import java.util.ArrayList;
import java.util.List;

public class PluginEngineExecutor {
    List<RulePluginEngine> plugins;

    public PluginEngineExecutor() {
        this.plugins = new ArrayList<>();
    }

    void registerPlugin(RulePluginEngine plugin) {
        plugin.onStateChange(RuleEngineState.State.INSTALLED);
        this.plugins.add(plugin);
    }

    void start() {
        for (RulePluginEngine plg : this.plugins) {
            plg.onStateChange(RuleEngineState.State.STARTED);
        }
    }
}
