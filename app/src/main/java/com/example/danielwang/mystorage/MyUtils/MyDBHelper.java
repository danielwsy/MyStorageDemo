package com.example.danielwang.mystorage.MyUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/17 9:34
 */
public class MyDBHelper extends SQLiteOpenHelper {

    public final static String DATABASE_FILTER_INFO = "my_data";
    private static final String DATABASE_NAME = "mydata.db";
    private static int dbOpenCount = 0;
    private static volatile SQLiteDatabase db = null;

    public MyDBHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DATABASE_FILTER_INFO + "("
                + "id int,"
                + "name text,"
                + "age int"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static MyDBHelper getDatabaseHelper(Context context, String name) {
        return new MyDBHelper(context, name);
    }

    public static synchronized SQLiteDatabase get(Context context) {
        dbOpenCount++;
        if (db == null) {
            dbOpenCount = 1;
            db = getDatabaseHelper(context, DATABASE_NAME).getWritableDatabase();
        }
        return db;
    }

    public static synchronized void close(SQLiteDatabase db) {
        dbOpenCount--;
        if (dbOpenCount <= 0) {
            dbOpenCount = 0;
            if (db != null) {
                db.close();
                MyDBHelper.db = null;
            }
        }
    }

}
