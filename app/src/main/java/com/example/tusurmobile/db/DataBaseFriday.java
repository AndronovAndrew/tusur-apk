package com.example.tusurmobile.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseFriday extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "friday.db";
    private static final int DATABASE_VERSION = 1;
    // SQL-запрос для создания таблицы
    private Context CONTEXT;
    private static final String CREATE_TABLE =
            "CREATE TABLE Monday (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "pair TEXT);";

    public DataBaseFriday(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        CONTEXT = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создание таблицы
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    @SuppressLint("Range")
    public String getPairById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"pair"};
        String selection = "id=?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query("Monday", columns, selection, selectionArgs, null, null, null);

        String pair = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                pair = cursor.getString(cursor.getColumnIndex("pair"));
            }
            cursor.close();
        }
        db.close();
        return pair;
    }
    public void insertPairs(String[] Pairs) {
        SQLiteDatabase db = this.getWritableDatabase();
        {
            for(String pair :Pairs) {
                ContentValues values = new ContentValues();
                values.put("pair", pair);
                db.insert("Monday", null, values);
            }
        }

        db.close();
    }
    public ArrayList<String> getAllPairs() {
        ArrayList<String> pairsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"pair"};
        Cursor cursor = db.query("Monday", columns, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String pair = cursor.getString(cursor.getColumnIndex("pair"));
                pairsList.add(pair);
            }
            cursor.close();
        }

        db.close();
        return pairsList;
    }
    public void clear(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from Monday");
        db.close();
    }
    public void Drop(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.close();
        CONTEXT.deleteDatabase(DATABASE_NAME);
    }
    public boolean hasData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT COUNT(*) FROM Monday";
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        db.close();
        return count > 0;
    }
}
