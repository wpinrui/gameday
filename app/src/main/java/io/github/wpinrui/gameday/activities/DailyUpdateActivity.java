package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.commons.Utils;
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;
import io.github.wpinrui.gameday.ui.DailyUpdateAdapter;

public class DailyUpdateActivity extends AppCompatActivity {

    private ArrayList<Statistic> statistics;
    private Model model;
    private RecyclerView rvStatistics;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_update);
        initElements();
    }

    private void initElements() {
        rvStatistics = findViewById(R.id.dailyUpdateRecycler);
        model = Model.getInstance();
        statistics = model.getStatistics();
        DailyUpdateAdapter adapter = new DailyUpdateAdapter(statistics);
        rvStatistics.setAdapter(adapter);
        rvStatistics.setLayoutManager(new LinearLayoutManager(this));
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(Utils.bottomNavigationListener(bottomNav, this));
//        bottomNav.setSelectedItemId(R.id.page_today);

    }
}
