package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RatingBar extends AppCompatActivity implements android.widget.RatingBar.OnRatingBarChangeListener {

    android.widget.RatingBar rb ;
    TextView tvRating ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        rb = findViewById(R.id.rbDemo) ;
        tvRating = findViewById(R.id.tvRating) ;
        rb.setOnRatingBarChangeListener(this);

    }

    @Override
    public void onRatingChanged(android.widget.RatingBar ratingBar, float rating, boolean fromUser) {
        tvRating.setText("Ratings: " + rating);
    }
}
