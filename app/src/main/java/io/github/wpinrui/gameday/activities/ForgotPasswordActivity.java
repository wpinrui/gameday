package io.github.wpinrui.gameday.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import io.github.wpinrui.gameday.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editEmail;
    private Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editEmail = findViewById(R.id.editTextEmailAddress);
        resetBtn = findViewById(R.id.resetBtn);

        resetBtn.setOnClickListener(v -> sendPasswordResetEmail(editEmail.getText().toString()));
    }

    private void sendPasswordResetEmail(String email) {
        System.out.println(email);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    System.out.println("done");
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Email sent", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, task.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
