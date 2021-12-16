package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.commons.Utils;
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;
import io.github.wpinrui.gameday.ui.StartAdapter;

public class StartActivity extends AppCompatActivity {

    private ArrayList<Statistic> statistics;
    private FloatingActionButton fab;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Utils.setColor(this, R.color.dark_primary);
        initElements();
    }

    private void initElements() {
        Model.initialise(onModelChanged);
        fab = findViewById(R.id.floating_action_button);
        fab.setEnabled(false);
        fab.setOnClickListener(v -> Utils.goToActivity(this, DailyUpdateActivity.class));
    }

    private final Runnable onModelChanged = () -> {
        model = Model.getInstance();
        fab.setEnabled(true);
        RecyclerView rvStatistics = findViewById(R.id.rvStatistics);
        statistics = model.getStatistics();
        StartAdapter adapter = new StartAdapter(statistics);
        rvStatistics.setAdapter(adapter);
        rvStatistics.setLayoutManager(new GridLayoutManager(this, 3)); // TODO: fix cut off
    };


}