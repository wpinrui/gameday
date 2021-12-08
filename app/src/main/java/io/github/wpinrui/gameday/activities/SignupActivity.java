package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;
import io.github.wpinrui.gameday.ui.Ui;

/**
 * Activity that allows a user to create an account.
 */
public class SignupActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;
    private EditText editPasswordConfirm;
    private Button signupBtn;
    private Button loginBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initElements();
    }

    private void initElements() {
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPasswordConfirm = findViewById(R.id.editPasswordConfirm);
        signupBtn = (Button) findViewById(R.id.signupBtn);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        signupBtn.setOnClickListener(v -> {
            if (password().equals(passwordConfirm())) {
                Auth.signup(email(), password(), () -> {
                    Utils.goToActivity(this, MainActivity.class);
                }, () -> {});
            } else {
                Ui.inform("Passwords do not match", this);
            }
        });

        loginBtn.setOnClickListener(v -> Utils.goToActivity(this, LoginActivity.class));
    }

    private String email() {
        return editEmail.getText().toString();
    }

    private String password() {
        return editPassword.getText().toString();
    }

    private String passwordConfirm() {
        return editPasswordConfirm.getText().toString();
    }
}
