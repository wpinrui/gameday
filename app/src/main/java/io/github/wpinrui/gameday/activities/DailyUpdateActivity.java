package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;
import io.github.wpinrui.gameday.ui.DailyUpdateAdapter;

public class DailyUpdateActivity extends AppCompatActivity {

    private ArrayList<Statistic> statistics;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_update);
        initElements();
    }

    private void initElements() {
        model = Model.getInstance();
        RecyclerView rvStatistics = findViewById(R.id.dailyUpdateRecycler);
        statistics = model.getStatistics();
        DailyUpdateAdapter adapter = new DailyUpdateAdapter(statistics);
        rvStatistics.setAdapter(adapter);
        rvStatistics.setLayoutManager(new LinearLayoutManager(this));
    }
}
