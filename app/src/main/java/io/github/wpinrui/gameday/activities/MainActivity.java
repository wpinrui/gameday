package io.github.wpinrui.gameday.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import io.github.wpinrui.gameday.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        checkLogin();
        setContentView(R.layout.activity_main);
    }

    private void checkLogin() {
//        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return;
//        }
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String userId = user.getUid();
    }
}