package io.github.wpinrui.gameday.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import io.github.wpinrui.gameday.storage.Storage;

public class Model implements Serializable {
    private final ArrayList<Statistic> statistics;
    private static Model model;

    public static void initialise(Runnable runnable) {
        try {
            Storage.readSave(m -> {
                model = m;
                runnable.run();
            });
        } catch (IOException e) {
            // TODO: handle write here
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isInitialised() {
        return model != null;
    }

    public static Model getInstance() {
        assert isInitialised();
        return model;
    }

    public Model() {
        this.statistics = new ArrayList<Statistic>();
    }

    public ArrayList<Statistic> getStatistics() {
        return statistics;
    }

    public void addStatistic(Statistic stat) {
        this.statistics.add(stat);
    }
}
