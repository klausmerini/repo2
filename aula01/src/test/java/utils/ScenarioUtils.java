package utils;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioUtils {

    private static Map<Long, Scenario> repository = new HashMap<>();

    public static void add(Scenario scenario) {
        if (get() == null) {
            repository.put(getId(), scenario);
        }
    }

    public static void remove(Scenario scenario) {
        if (get() == null) {
            repository.remove(getId());
        }
    }

    private static Long getId() {
        // TODO Auto-generated method stub
        return Thread.currentThread().getId();
    }

    private static Scenario get() {
        // TODO Auto-generated method stub
        return repository.get(getId());
    }

    public static void addText(String value) {
        // TODO Auto-generated method stub

    }

}
