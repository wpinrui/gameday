package io.github.wpinrui.gameday.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import io.github.wpinrui.gameday.MainActivity;
import io.github.wpinrui.gameday.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button forgotPasswordButton;
    private Button signUpButton;
    private ProgressBar loadingProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        initBindings();
        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            signIn(usernameEditText.getText().toString(), passwordEditText.getText().toString());
        });
        forgotPasswordButton.setOnClickListener(v -> {
            goToForgotPassword();
        });
        signUpButton.setOnClickListener(v -> {
            goToSignUp();
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        showLoginMessage(R.string.welcome);
                        goToMain();
                    } else {
                        showLoginMessage(R.string.login_failed);
                        loadingProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    private void initBindings() {
        io.github.wpinrui.gameday.databinding.ActivityLoginBinding binding = io.github.wpinrui.gameday.databinding.ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        usernameEditText = binding.username;
        passwordEditText = binding.password;
        loginButton = binding.login;
        forgotPasswordButton = binding.forgotPasswordBtn;
        loadingProgressBar = binding.loading;
        signUpButton = binding.signUpBtn;
    }

    private void showLoginMessage(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_LONG).show();
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToForgotPassword() {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private void goToSignUp() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }


}