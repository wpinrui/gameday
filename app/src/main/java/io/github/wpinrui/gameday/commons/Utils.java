package io.github.wpinrui.gameday.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import io.github.wpinrui.gameday.R;

/**
 * Collection of static methods used by various classes.
 */
public class Utils {
    public static void goToActivity(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    public static void setColor(Activity activity, int color) {
        activity.getWindow().setStatusBarColor(
                activity.getResources().getColor(R.color.dark_primary, activity.getTheme()));
    }
}
