package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.commons.Utils;
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;
import io.github.wpinrui.gameday.storage.Storage;
import io.github.wpinrui.gameday.ui.DailyUpdateAdapter;

public class DailyUpdateActivity extends AppCompatActivity {

    private ArrayList<Statistic> statistics;
    private Button confirmBtn;
    private Model model;
    private RecyclerView rvStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_update);
        initElements();
    }

    private void initElements() {
        confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(v -> {
            try {
                Storage.writeSave(model);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Utils.goToActivity(this, StartActivity.class);
        });
        rvStatistics = findViewById(R.id.dailyUpdateRecycler);
        model = Model.getInstance();
        statistics = model.getStatistics();
        DailyUpdateAdapter adapter = new DailyUpdateAdapter(statistics);
        rvStatistics.setAdapter(adapter);
        rvStatistics.setLayoutManager(new LinearLayoutManager(this));
    }
}
