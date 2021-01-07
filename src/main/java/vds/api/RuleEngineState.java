package vds.api;

public interface RuleEngineState {
    enum State {
        INSTALLED,
        FAILED,
        STARTED,
        STOPPED
    }
    State getState();

    void bindingPlugin(RulePluginEngine pluginEngine);
}
