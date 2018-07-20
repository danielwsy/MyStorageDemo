package com.example.danielwang.mystorage.MyUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.danielwang.mystorage.Bean.Person;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/17 9:43
 */
public class MyDataDao {

    /**
     * 插入信息
     *
     * @param context
     * @param person
     */
    public static void insert(Context context, Person person) {
        SQLiteDatabase db = MyDBHelper.get(context);
        ContentValues values = makeValue(person);
        db.insert(MyDBHelper.DATABASE_FILTER_INFO, null, values);
        MyDBHelper.close(db);
    }

    private static ContentValues makeValue(Person person) {
        ContentValues values = new ContentValues();
        values.put("id", person.id);
        values.put("name", person.name);
        values.put("age", person.age);
        return values;
    }


    /**
     * 删除
     *
     * @param context
     * @param name
     */
    public static void delete(Context context, String name) {
        SQLiteDatabase db = MyDBHelper.get(context);
        db.delete(MyDBHelper.DATABASE_FILTER_INFO, "type=?", new String[]{name});
        MyDBHelper.close(db);
    }

    /**
     * 查询
     *
     * @param context
     * @return
     */
    public static Person queryAllProgressInfo(Context context, String type) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Person bean = null;
        try {
            db = MyDBHelper.get(context);
            cursor = db.query(MyDBHelper.DATABASE_FILTER_INFO, null, "type=?", new String[]{type}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    bean = parseStickerCursor(cursor);
                }
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                MyDBHelper.close(db);
            }
        }
        return bean;
    }

    private static Person parseStickerCursor(Cursor cursor) {
        Person person = new Person();
        person.id = cursor.getInt(0);
        person.name = cursor.getString(1);
        person.age = cursor.getInt(2);
        return person;
    }

}
