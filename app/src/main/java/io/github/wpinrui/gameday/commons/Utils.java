package io.github.wpinrui.gameday.commons;

import android.content.Context;
import android.content.Intent;

public class Utils {
    public static void goToActivity(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
