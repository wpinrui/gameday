package io.github.wpinrui.gameday.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Statistic implements Serializable {
    private String name;
    private String shortName;
    private String description;
    private Map<String, Double> presets;
    private Map<Date, Double> history;

    public void setName(String name) {
        this.name = name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPresets(Map<String, Double> presets) {
        this.presets = presets;
    }

    public void setHistory(Map<Date, Double> history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getPresets() {
        return presets;
    }

    public Map<Date, Double> getHistory() {
        return history;
    }
}
