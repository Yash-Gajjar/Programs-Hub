package com.example.exampreparation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonDBHelper extends SQLiteOpenHelper {

    public static final String TABLE_PERSON = "tblperson";
    public static final String FIELD_PERSON_FIRST_NAME = "first_name";
    public static final String CREATE_TABLE_PERSON = "create table "+TABLE_PERSON+"("+FIELD_PERSON_FIRST_NAME+" text)";

    public PersonDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        Creating the table


//        db.execSQL("DROP TABLE IF EXISTS " +TABLE_PERSON);
        db.execSQL(CREATE_TABLE_PERSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
