package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;

/**
 * Activity that allows user to reset their password by sending a password reset email to their
 * email address.
 */
public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editEmail;
    private Button resetBtn;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initElements();
        Utils.setNotificationBarColor(this, R.color.plain);
        Utils.setLightNotificationTextColor(this);
    }

    private void initElements() {
        editEmail = findViewById(R.id.editTextEmailAddress);
        resetBtn = findViewById(R.id.resetBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        resetBtn.setOnClickListener(
                v -> {
                    Auth.sendPasswordResetEmail(editEmail.getText().toString(),
                            () -> {},
                            () -> {});

                }
        );
        cancelBtn.setOnClickListener(v -> Utils.goToActivity(this, LoginActivity.class));
    }


}
