package io.github.wpinrui.gameday.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;

/**
 * The main screen where the user gets an overview of their statistics for the season. If there is
 * no logged-in account, the user is directed to the LoginActivity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (Auth.isLoggedIn()) {
            Utils.goToActivity(this, StartActivity.class);
        } else {
            Utils.goToActivity(this, LoginActivity.class);
        }
        setContentView(R.layout.activity_main);
    }
}