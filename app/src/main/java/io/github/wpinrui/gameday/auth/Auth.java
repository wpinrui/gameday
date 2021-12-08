package io.github.wpinrui.gameday.auth;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Encapsulates all methods directly related to Firebase authentication.
 */
public class Auth {

    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    /**
     * Sends a password reset email to the given email if the account with the given email exists.
     *
     * @param email Email address used by the user to login
     * @param onSuccess Action to run when the reset email is successfully sent
     */
    public static void sendPasswordResetEmail(String email, Runnable onSuccess) {
        System.out.println(email);
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        onSuccess.run();
                    } else {
                        throw new AuthenticationException(AuthenticationFailureType.RESET_FAILURE);
                    }
                });
    }

    /**
     * Attempts to sign in the user using the given email address and password.
     *
     * @param email Email address used by the user to login
     * @param password Password used by the user to login
     * @param onSuccess Action to run when the login is successful
     */
    public static void signIn(String email, String password, Runnable onSuccess) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        onSuccess.run();
                    } else {
                        throw new AuthenticationException(AuthenticationFailureType.LOGIN_FAILURE);
                    }
                });
    }

    /**
     * Attempts to sign up the user using the given email address and password. Logs the user in if
     * the sign up is successful.
     *
     * @param email Email address used by the user to sign up
     * @param password Password used by the user to sign up
     * @param onSuccess Action to run when the login is successful
     */
    public static void signup(String email, String password, Runnable onSuccess) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                task -> {
                    if (task.isSuccessful()) {
                        onSuccess.run();
                    } else {
                        throw new AuthenticationException(AuthenticationFailureType.SIGNUP_FAILURE);
                    }
                }
        );
    }

    /**
     * Checks if any user is logged in currently.
     *
     * @return true iff a user is logged in
     */
    public static boolean isLoggedIn() {
        mAuth.signOut();
        return mAuth.getCurrentUser() != null;
    }
}
