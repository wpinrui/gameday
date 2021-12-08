package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.auth.Auth;
import io.github.wpinrui.gameday.commons.Utils;

/**
 * Activity that allows the user to sign in if they have an account, or direct them to sign up or
 * reset their password as required.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button forgotPasswordButton;
    private Button signUpButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initElements();
    }


    private void initElements() {
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        forgotPasswordButton = findViewById(R.id.forgotPasswordBtn);
        signUpButton = findViewById(R.id.signUpBtn);

        loginButton.setOnClickListener(v -> {

            Auth.signIn(username(), password(), () -> {
                Utils.goToActivity(this, MainActivity.class);
            }, () -> {});
        });
        forgotPasswordButton.setOnClickListener(v -> {
            Utils.goToActivity(this, ForgotPasswordActivity.class);
        });
        signUpButton.setOnClickListener(v -> {
            Utils.goToActivity(this, SignupActivity.class);
        });
    }

    private String username() {
        return usernameEditText.getText().toString();
    }

    private String password() {
        return passwordEditText.getText().toString();
    }
}
