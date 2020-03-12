package com.example.bookstore.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Utility {

    private static Dialog dialog;
    private static AlertDialog alertDialog;

    private static final String KEY_TOKEN = "keyToken";

    public static void openFragment(FragmentManager supportFragmentManger, Fragment fragment, int container_id) {
        FragmentTransaction trans = supportFragmentManger.beginTransaction();
        trans.replace(container_id, fragment);
        trans.commit();
    }

    public static void showDialog(Activity activity, String title) {

        try {
            dialog = new ProgressDialog(activity);
            dialog.setTitle(title);
            dialog.setCancelable(false);
            dialog.show();

        } catch (Exception e) {e.printStackTrace();}
    }

    public static void hideDialog() {

        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {e.printStackTrace();}
    }


    public static void saveToken(Context context, String accessToken) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(KEY_TOKEN, accessToken);
        editor.apply();
    }

    public static String getToken(Context context) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(KEY_TOKEN, null);
    }

}
