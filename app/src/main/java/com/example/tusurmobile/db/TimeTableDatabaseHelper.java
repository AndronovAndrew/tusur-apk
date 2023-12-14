package com.example.tusurmobile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class TimeTableDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TimeTable.db";
    private static final int DATABASE_VERSION = 1;

    public TimeTableDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создаем таблицы для каждого дня недели
        createTable(db, "TableMonday");
        createTable(db, "TableTuesday");
        createTable(db, "TableWednesday");
        createTable(db, "TableThursday");
        createTable(db, "TableFriday");
        createTable(db, "TableSaturday");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Метод вызывается при изменении версии базы данных (не рассматриваем в данном примере)
    }

    private void createTable(SQLiteDatabase db, String tableName) {
        // Создаем таблицу с полем текста, которое заполняется только 1 раз
        String createTableQuery = "CREATE TABLE " + tableName + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "data TEXT," +
                "isFilled INTEGER DEFAULT 0)";
        db.execSQL(createTableQuery);
    }
    public static boolean isDbExist(Context context){
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    public static void dropDb(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}