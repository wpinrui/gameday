package io.github.wpinrui.gameday.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.activities.DailyUpdateActivity;
import io.github.wpinrui.gameday.activities.StartActivity;

/**
 * Collection of static methods used by various classes.
 */
public class Utils {
    public static void goToActivity(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    public static void setNotificationBarColor(Activity activity, int color) {
        activity.getWindow().setStatusBarColor(
                activity.getResources().getColor(color, activity.getTheme()));
    }

    public static void setLightNotificationTextColor(Activity activity) {
        System.out.println(activity.getResources().getString(R.string.ui_mode));
        if (activity.getResources().getString(R.string.ui_mode).equals("Light")) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static NavigationBarView.OnItemSelectedListener bottomNavigationListener(
            BottomNavigationView bottomNav, Activity activity) {
        return item -> {
            switch (item.getItemId()) {
                // TODO
                case R.id.page_overview:
                    Utils.goToActivity(activity, StartActivity.class);
                    activity.finish();
                    break;
                case R.id.page_settings:
                case R.id.page_history:
                    break;
                case R.id.page_today:
                    Utils.goToActivity(activity, DailyUpdateActivity.class);
                    activity.finish();
                    break;
                default:
                    assert false; // should not be reached
            }
            return true;
        };
    }

}
