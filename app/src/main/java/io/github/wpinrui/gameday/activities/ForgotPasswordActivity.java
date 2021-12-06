package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editEmail;
    private Button resetBtn;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initElements();
    }

    private void initElements() {
        editEmail = findViewById(R.id.editTextEmailAddress);
        resetBtn = findViewById(R.id.resetBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        resetBtn.setOnClickListener(
                v -> Auth.sendPasswordResetEmail(editEmail.getText().toString(), this)
        );
        cancelBtn.setOnClickListener(v -> Utils.goToActivity(this, LoginActivity.class));
    }


}
