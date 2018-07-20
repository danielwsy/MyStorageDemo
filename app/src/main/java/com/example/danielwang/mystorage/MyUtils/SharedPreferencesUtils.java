package com.example.danielwang.mystorage.MyUtils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/16 10:42
 */
public class SharedPreferencesUtils {
    private static SharedPreferences sp;
    private static String FILE_NAME = "my_storage";

    private static SharedPreferences getInstance(Context context) {
        if (sp == null) {
            sp = context.getApplicationContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getInstance(context).getString(key, defaultValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getInstance(context).getInt(key, defaultValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static Boolean getBoolean(Context context, String key, Boolean defaultValue) {
        return getInstance(context).getBoolean(key, defaultValue);
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void putStringsToJson(Context context, String key, List<String> data) {
        getInstance(context).edit().putString(key, data.toString()).apply();
    }

    public static ArrayList<String> getJsonString(Context context, String key) {
        String collectedpics = getInstance(context).getString(key, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (null != collectedpics) {
            try {
                JSONArray jsonArray = new JSONArray(collectedpics);
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add((String) jsonArray.get(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

}
