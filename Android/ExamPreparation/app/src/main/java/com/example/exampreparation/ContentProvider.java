package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContentProvider extends AppCompatActivity implements View.OnClickListener {

    Button btnAddPerson, btnShowPeople ;
    ListView lstPeople ;
    EditText etPersonName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        btnAddPerson = findViewById(R.id.btnAddNewPerson) ;
        btnShowPeople = findViewById(R.id.btnShowPeople) ;
        etPersonName = findViewById(R.id.etPersonName) ;

        btnAddPerson.setOnClickListener(this);
        btnShowPeople.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnAddNewPerson:
                addNewPerson() ;
                break ;
            case R.id.btnShowPeople :
                showPeople() ;
                break ;
        }

    }

    private void showPeople() {

        PersonDataSource pds = new PersonDataSource(this) ;

        Log.d("From ContentProvider: ", "In showPeople() - Before pds.showPeople()");

        ArrayList<Person> peopleList = pds.showPeople() ;
        Log.d("From ContentProvider: ", "In showPeople() - after pds.showPeople()");

        Log.d("From ContentProvider:  ", "In showPeople() - peopleList Length : " +peopleList.size());

        ArrayAdapter<Person> adapter = new ArrayAdapter<>(this, R.layout.lst_people_firstname, peopleList) ;
        lstPeople.setAdapter(adapter);

    }

    private void addNewPerson() {

        PersonDataSource pds = new PersonDataSource(this) ;

        Person person = new Person();

        person.setFirstName(etPersonName.getText().toString());

        pds.add(person) ;
        etPersonName.setText("");

    }
}
