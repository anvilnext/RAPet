package cucumber;

import java.util.HashMap;
import java.util.Map;
import enums.Context;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public <T> void setContext(Context key, T value) {
        scenarioContext.put(key.toString(), value);
    }

    public <T> T getContext(Context key){
        return (T) scenarioContext.get(key.toString());
    }

    public Boolean contains(Context key){
        return scenarioContext.containsKey(key.toString());
    }

}