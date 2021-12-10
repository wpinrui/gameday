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

    public Statistic() {}

    public Statistic(String name, String shortName, String description, double min, double max) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        presets.put("MIN", min);
        presets.put("MAX", max);
    }

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

    public void addHistory(Date date, double value) {
        history.put(date, value);
    }

    public void addPreset(String s, double value) {
        presets.put(s, value);
    }

    public double getCurrentSeasonAverage() {
        return 24.8;
    }

    public double getMax() {
        return presets.get("MAX");
    }

    public double getMin() {
        return presets.get("MIN");
    }
}
