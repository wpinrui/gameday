package io.github.wpinrui.gameday.ui;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * Encapsulate methods related to the Ui and displaying messages to the user.
 */
public class Ui {
    public static void showLoginMessage(@StringRes Integer errorString, Context context) {
        Toast.makeText(context, errorString, Toast.LENGTH_LONG).show();
    }

    public static void inform(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
