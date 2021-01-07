package vds.api;

public interface RulePluginEngine {
    String name();
    void onStateChange(RuleEngineState.State state);
}
