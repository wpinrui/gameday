package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Auth.isLoggedIn()) {
            // go to start screen
        } else {
            Utils.goToActivity(this, LoginActivity.class);
        }
        setContentView(R.layout.activity_main);
    }
}