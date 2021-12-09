package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;
import io.github.wpinrui.gameday.storage.Storage;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Launching");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        tryReading();
    }

    private void tryReading() {
        try {
            Storage.readSave(new Storage.CallBack() {
                @Override
                public void onCallBack(Model m) {
                    System.out.println(m.toString());
                }
            });
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void tryWriting() {
        Model model = new Model();
        List<Statistic> statistics = model.getStatistics();
        Statistic example = new Statistic();
        example.setName("Example");
        example.setShortName("EG");
        statistics.add(example);
        try {
            Storage.writeSave(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}