package com.example.contentprovider;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lstRecords ;
    EditText etPersonName ;
    Button btnAddRecord, btnShowRecords ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstRecords = findViewById(R.id.lstRecords) ;
        etPersonName = findViewById(R.id.etPersonName) ;
        btnAddRecord = findViewById(R.id.btnAddRecord) ;
        btnShowRecords = findViewById(R.id.btnShowRecords) ;

        btnShowRecords.setOnClickListener(this);
        btnAddRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnAddRecord:
                addRecord() ;
                break ;
            case R.id.btnShowRecords:
                showRecords() ;
                break ;
        }

    }

    private void showRecords() {

        CoderDataSource cds = new CoderDataSource(this) ;

        ArrayList<Coders> allCoders =  cds.showAllRecords() ;

        Log.d("From Main Activity", "allCoders" +allCoders.size()) ;

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.lst_coders, allCoders);

        lstRecords.setAdapter(adapter);

    }

    private void addRecord() {

        CoderDataSource cds = new CoderDataSource(this) ;

        cds.addCoder(etPersonName.getText().toString().trim()) ;

        etPersonName.setText("");
        Toast.makeText(this, "Record Inserted!!", Toast.LENGTH_SHORT).show();

    }
}
