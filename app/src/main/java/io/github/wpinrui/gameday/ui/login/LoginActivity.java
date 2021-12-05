package io.github.wpinrui.gameday.ui.login;

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
import io.github.wpinrui.gameday.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        io.github.wpinrui.gameday.databinding.ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usernameEditText = binding.username;
        passwordEditText = binding.password;
        loginButton = binding.login;
        loadingProgressBar = binding.loading;

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            signIn(usernameEditText.getText().toString(), passwordEditText.getText().toString());
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        showLoginMessage(R.string.welcome);
                        goToMain();
                        finish();
                    } else {
                        showLoginMessage(R.string.login_failed);
                        loadingProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    private void showLoginMessage(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_LONG).show();
    }

    private void goToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}