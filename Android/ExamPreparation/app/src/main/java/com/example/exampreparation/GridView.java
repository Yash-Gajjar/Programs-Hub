package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class GridView extends AppCompatActivity {

    android.widget.GridView gridView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.sampleGridView) ;

        String[] tempValues = {"CoderBoy", "Havado", "Chars", "Gutkha", "Tarbuch", "Line Maru", "Pati", "Patni", "Middle Man"} ;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tempValues) ;

        gridView.setAdapter(arrayAdapter);



    }
}
