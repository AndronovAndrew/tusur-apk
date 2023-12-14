package com.example.tusurmobile.db;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TimeTableOperation {
        private SQLiteDatabase database;
        private TimeTableDatabaseHelper dbHelper;

        public TimeTableOperation(Context context) {
            dbHelper = new TimeTableDatabaseHelper(context);
        }

        public void open() {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public void insertData(String tableName, String data) {
            ContentValues values = new ContentValues();
            values.put("data", data);

            // Вставляем данные в таблицу
            database.insert(tableName, null, values);
        }

        @SuppressLint("Range")
        public String fetchData(String tableName) {
            String result = null;
            Cursor cursor = database.query(tableName, new String[]{"data"}, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndex("data"));
//                Log.d("Logcat",result);
            }
            cursor.close();
            return result;
        }

        @SuppressLint("Range")
        public boolean isDataFilled(String tableName) {
            Cursor cursor = database.query(tableName, new String[]{"isFilled"}, null, null, null, null, null);
            boolean isFilled = false;
            if (cursor.moveToFirst()) {
                isFilled = cursor.getInt(cursor.getColumnIndex("isFilled")) == 1;
            }
            cursor.close();
            return isFilled;
        }

        public void markDataAsFilled(String tableName) {
            ContentValues values = new ContentValues();
            values.put("isFilled", 1);

            // Обновляем поле isFilled в таблице
            database.update(tableName, values, null, null);
        }

        public void deleteTable(String tableName) {
            // Удаляем таблицу
            database.execSQL("DROP TABLE IF EXISTS " + tableName);
        }
}
