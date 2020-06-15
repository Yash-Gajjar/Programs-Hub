package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class DialogBox extends AppCompatActivity implements View.OnClickListener {

    Button btnDefaultDialogBox, btnCustomDialogBox ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        btnCustomDialogBox = findViewById(R.id.btnCustomDialog) ;
        btnDefaultDialogBox = findViewById(R.id.btnDefaultDialog) ;

        btnDefaultDialogBox.setOnClickListener(this);
        btnCustomDialogBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCustomDialog:
                showCustomDialog() ;
                break ;
            case R.id.btnDefaultDialog:
                showDefaultDialog() ;
                break ;
        }

    }

    private void showDefaultDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;

        builder.setTitle("Hello There!") ;
        builder.setMessage("This is Default DialogBox!") ;
        builder.setPositiveButton("Okay", null) ;
        builder.setNegativeButton("Cancel", null) ;

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;

        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.custom_dialogbox, null)) ;

        builder.setTitle("Custom Dialog") ;
        builder.setPositiveButton("Submit", null) ;
        builder.setNegativeButton("Cancel", null) ;

        AlertDialog alertDialog = builder.create() ;
        alertDialog.show();
    }
}
