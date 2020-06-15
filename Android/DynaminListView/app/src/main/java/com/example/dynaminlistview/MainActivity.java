package com.example.dynaminlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd ;
    Button btnRefresh ;
    ListView lstValues ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnRefresh = findViewById(R.id.btnRefresh);
        lstValues = findViewById(R.id.lstValues);

        btnRefresh.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

    }

    void displayData() {

        SharedPreferences sharedPreferences = getSharedPreferences("AppShared", MODE_PRIVATE);

        Map<String, ?> keyPairValues = sharedPreferences.getAll();

        Set<String> keySet = keyPairValues.keySet();

        Iterator<String> iterator = keySet.iterator();



        int counter = 0 ;

        String[] values = new String[keyPairValues.size()];

        while(iterator.hasNext()) {

            String cKey = iterator.next();
            String cValue = sharedPreferences.getString(cKey, "");

            values[counter++] = cKey + " : " +cValue;

        }

        Adapter adapter = new ArrayAdapter<>(this, R.layout.list_view_textview, values);

        lstValues.setAdapter((ListAdapter) adapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnAdd:
                this.startActivity(new Intent(this, AddData.class));
                break;
            case  R.id.btnRefresh:
                displayData();
                break;
        }

    }
}
