package io.github.wpinrui.gameday.model;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Statistic implements Serializable {
    private String name;
    private String shortName;
    private String description;
    private Map<String, Double> presets;
    private Map<String, Double> history;

    public Statistic() {
    }

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

    public void setHistory(Map<String, Double> history) {
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

    public Map<String, Double> getHistory() {
        return history;
    }

    public void addHistory(String date, double value) {
        history.put(date, value);
    }

    public void addPreset(String s, double value) {
        presets.put(s, value);
    }

    public double getCurrentSeasonAverage() {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(df.format(
                getCurrentSeasonHistory()
                        .values()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0)));
    }

    private Map<String, Double> getCurrentSeasonHistory() {
        Map<String, Double> output = new HashMap<>();
        for (String key : history.keySet()) {
            if (isCurrentSeason(key)) {
                output.put(key, history.get(key));
            }
        }
        return output;
    }

    private boolean isCurrentSeason(String key) {
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();
        LocalDate dateToCheck = LocalDate.parse(key);
        return dateToCheck.getMonthValue() == currentMonth && dateToCheck.getYear() == currentYear;
    }

    public double getMax() {
        return presets.get("MAX");
    }

    public double getMin() {
        return presets.get("MIN");
    }

    public boolean hasProgressToday() {
        return history.containsKey(LocalDate.now().toString());
    }

    public double dailyProgress() {
        if (hasProgressToday()) {
            return history.get(LocalDate.now().toString());
        }
        return getMin();
    }

    public void updateDailyProgress(double value) {
        if (hasProgressToday()) {
            history.replace(LocalDate.now().toString(), value);
        } else {
            history.put(LocalDate.now().toString(), value);
        }
    }
}
