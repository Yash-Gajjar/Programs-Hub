package com.example.exampreparation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

class PersonDataSource {

    private final Context context;
    private PersonDBHelper personDBHelper ;
    private SQLiteDatabase db ;

    public PersonDataSource(Context context) {

        this.context = context ;
        personDBHelper = new PersonDBHelper(context, PersonDBHelper.TABLE_PERSON, null,1);
    }

    public void add(Person person) {

        db = personDBHelper.getWritableDatabase() ;

//        ContentValues stores data into key-value pair
//        Here, the value of each field is being stored
        ContentValues cValues = new ContentValues();
        cValues.put(personDBHelper.FIELD_PERSON_FIRST_NAME, person.getFirstName());

//        after storing values of each field, it's time to insert the data
        db.insert(personDBHelper.TABLE_PERSON, personDBHelper.FIELD_PERSON_FIRST_NAME, cValues) ;
    }

    public ArrayList<Person> showPeople() {

/*
        ArrayList<Student> al = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

        String[] columnsToFetch = {MyDBHelper.FIELD_STUDENT_FIRST_NAME};

        Cursor rs = db.query(MyDBHelper.TABLE_STUDENTS, columnsToFetch, null, null, null, null, sorting);

        for ( rs.moveToFirst() ; ! rs.isAfterLast() ; rs.moveToNext() ){
            String fn = rs.getString(rs.getColumnIndex(MyDBHelper.FIELD_STUDENT_FIRST_NAME));

            Student st = new Student();
            st.setFirstName(fn);

            al.add(st);
        }
        return al;*/

        ArrayList<Person> peopleList = new ArrayList<>() ;
        db = personDBHelper.getReadableDatabase() ;

        String[] columnsList = {PersonDBHelper.FIELD_PERSON_FIRST_NAME};
        Cursor cursor = db.query(PersonDBHelper.TABLE_PERSON, columnsList, null, null, null, null, null);

        Log.d("From PDS: ", "In showPeople()");


        for(cursor.moveToFirst(); ! cursor.isAfterLast(); cursor.moveToNext()) {
            Person p = new Person() ;

            p.setFirstName(cursor.getString(cursor.getColumnIndex(PersonDBHelper.FIELD_PERSON_FIRST_NAME)));

            Log.d("From PDS: - For Loop : ", "Name = " + cursor.getString(cursor.getColumnIndex(PersonDBHelper.FIELD_PERSON_FIRST_NAME)));

            peopleList.add(p) ;
        }

        Log.d("From PDS: ", "In showPeople() - After For Loop");

        return peopleList;
    }
}
