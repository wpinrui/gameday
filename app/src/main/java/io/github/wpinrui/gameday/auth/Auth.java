package io.github.wpinrui.gameday.auth;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;

import io.github.wpinrui.gameday.activities.MainActivity;
import io.github.wpinrui.gameday.commons.Utils;

public class Auth {

    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static void sendPasswordResetEmail(String email, Context context) {
        System.out.println(email);
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        System.out.println("Email sent");
                    } else {
                        System.out.println("Failed to send email");
                    }
                });
    }


    public static void signIn(String email, String password, Context context) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        System.out.println("Login successful");
                        Utils.goToActivity(context, MainActivity.class);
                    } else {
                        System.out.println("Login failed");
                    }
                });
    }

    public static void signup(String email, String password, Context context) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        System.out.println("Sign up successful");
                        Utils.goToActivity(context, MainActivity.class);
                    } else {
                        System.out.println("Sign up failed");
                    }
                }
        );
    }

    public static boolean isLoggedIn() {
        mAuth.signOut();
        return mAuth.getCurrentUser() != null;
    }
}
