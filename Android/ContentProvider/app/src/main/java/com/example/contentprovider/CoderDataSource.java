package com.example.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CoderDataSource {


    private final Context context ;
    private final DBHelper dbHelper;
    private SQLiteDatabase db ;

    public CoderDataSource(Context context) {

        this.context = context ;

        dbHelper = new DBHelper(context, DBHelper.TABLE_CODERS, null, 1) ;
    }

    public void addCoder(String coderName) {

        db = dbHelper.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(DBHelper.FIELD_CODER_NAME, coderName);

        db.insert(DBHelper.TABLE_CODERS,null, contentValues) ;
    }


    public ArrayList<Coders> showAllRecords() {
        ArrayList<Coders> allCoders = new ArrayList<>() ;

        db = dbHelper.getReadableDatabase() ;

        String[] columnsToFetch = {DBHelper.FIELD_CODER_NAME};
        Cursor cursor = db.query(DBHelper.TABLE_CODERS, columnsToFetch, null, null, null, null, null);

//        Cursor cursor = db.rawQuery("select '" + DBHelper.FIELD_CODER_NAME + "' from " + DBHelper.TABLE_CODERS, null);;

        for(cursor.moveToFirst(); ! cursor.isAfterLast(); cursor.moveToNext()) {

            Coders coders = new Coders() ;
            coders.setName(cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_CODER_NAME)));

            allCoders.add(coders);
        }

        return allCoders;
    }
}
