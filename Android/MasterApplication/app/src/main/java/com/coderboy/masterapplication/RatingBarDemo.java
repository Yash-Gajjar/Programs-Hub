package com.coderboy.masterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarDemo extends AppCompatActivity implements View.OnClickListener {

    Button btnShowRating ;
    RatingBar rbRatings ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_demo);

        btnShowRating = findViewById(R.id.btnShowRatings) ;
        rbRatings = findViewById(R.id.rbRating) ;

        btnShowRating.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Ratings: "+rbRatings.getRating(), Toast.LENGTH_SHORT).show();
    }
}