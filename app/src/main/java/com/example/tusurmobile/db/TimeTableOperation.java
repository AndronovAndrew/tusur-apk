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

        public void insertData(String tableName, String data,String faculty,String group) {
            ContentValues values = new ContentValues();
            values.put("data", data);
            values.put("data_group", group);
            values.put("data_faculty", faculty);
            // Вставляем данные в таблицу
            database.insert(tableName, null, values);
        }

        @SuppressLint("Range")
        public String fetchData(String tableName,String group_name, String faculty) {
            String result = null;
            String selection = "data_group = ? AND data_faculty = ?";
            String[] selectionArgs = {group_name,faculty};
            Cursor cursor = database.query(tableName, null ,selection, selectionArgs, null, null, null);
            if (cursor.moveToFirst() && cursor!= null) {
                result = cursor.getString(cursor.getColumnIndex("data"));
//                Log.d("Logcat",result);
            }
            cursor.close();
            return result;
        }

        public boolean checkData(String group, String faculty, String tableName){
            try {
                open();
                SQLiteDatabase database = dbHelper.getReadableDatabase();
                String query = "SELECT COUNT(*) FROM " + tableName + " WHERE data_group = ? AND data_faculty = ?";

                // Выполняем запрос и получаем результат
                Cursor cursor = database.rawQuery(query, new String[]{group, faculty});

                // Проверяем наличие записи
                boolean recordExists = false;
                if (cursor != null && cursor.moveToFirst()) {
                    int count = cursor.getInt(0);
                    if (count > 0) {
                        recordExists = true;
                    }
                }

                // Закрываем курсор и базу данных
                if (cursor != null) {
                    cursor.close();
                }
                close();
                Log.d("Pidor", String.valueOf(recordExists));
                // Возвращаем результат
                return recordExists;
            }
            catch (Exception ex){
                return false;
            }
        }
}
