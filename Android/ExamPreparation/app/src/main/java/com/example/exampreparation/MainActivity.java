package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSharedPreferences ;
    Button btnContentProvider ;
    Button btnDialogBox ;
    Button btnResources ;
    Button btnRatingBar ;
    Button btnSlideBar ;
    Button btnGridView ;
    Button btnAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContentProvider = findViewById(R.id.btnContentProvider);
        btnContentProvider.setOnClickListener(this);

        btnDialogBox = findViewById(R.id.btnDialogBox);
        btnDialogBox.setOnClickListener(this);

        btnResources = findViewById(R.id.btnResources);
        btnResources.setOnClickListener(this);

        btnSharedPreferences = findViewById(R.id.btnSharePreferences);
        btnSharedPreferences.setOnClickListener(this);

        btnRatingBar = findViewById(R.id.btnRatingBar);
        btnRatingBar.setOnClickListener(this);

        btnSlideBar = findViewById(R.id.btnSliderBar);
        btnSlideBar.setOnClickListener(this);

        btnGridView = findViewById(R.id.btnGridView);
        btnGridView.setOnClickListener(this);

        btnAnimation = findViewById(R.id.btnAnimation);
        btnAnimation.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int[] btnIDs = {R.id.btnContentProvider, R.id.btnDialogBox, R.id.btnGridView, R.id.btnRatingBar, R.id.btnSliderBar, R.id.btnAnimation,  R.id.btnResources, R.id.btnSharePreferences} ;
        Class[] classesArray = {ContentProvider.class, DialogBox.class, GridView.class, RatingBar.class, SlideBar.class, AnimationDemo.class};

        int btnIndex = 0;

        for (int i = 0; i<btnIDs.length; i++) {
            if(btnIDs[i] == v.getId()){
                btnIndex = i ;
                break ;
            }
        }

        Toast.makeText(this, "Button Index: " + btnIndex, Toast.LENGTH_LONG).show();
        this.startActivity(new Intent(this, classesArray[btnIndex]));
    }


}
