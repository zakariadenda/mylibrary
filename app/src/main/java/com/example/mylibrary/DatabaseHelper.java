package com.example.mylibrary;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static String DATABASE_NAME = "student_database";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_STUDENTS = "students";
    private static final String KEY_ID = "id";
    public static final String KEY_FIRSTNAME = "name";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_FIRSTNAME + "TEXT );";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS '" +TABLE_STUDENTS + "'");
        onCreate(db);
    }


}






