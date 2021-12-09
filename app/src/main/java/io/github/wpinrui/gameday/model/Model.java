package io.github.wpinrui.gameday.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {
    private final List<Statistic> statistics;

    public Model() {
        this.statistics = new ArrayList<Statistic>();
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }
}
