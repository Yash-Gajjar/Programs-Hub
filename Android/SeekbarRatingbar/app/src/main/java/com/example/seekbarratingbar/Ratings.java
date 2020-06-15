package com.example.seekbarratingbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class Ratings extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    RatingBar ratingBar ;
    TextView tvMessage ;
    EditText etSuggestions ;
    Switch swHalfStar ;
    Button btnSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        ratingBar = findViewById(R.id.ratingBar) ;
        tvMessage = findViewById(R.id.tvMessage) ;
        etSuggestions = findViewById(R.id.etSuggestions) ;
        swHalfStar = findViewById(R.id.swSteps);
        btnSubmit = findViewById(R.id.btnSubmit) ;

        ratingBar.setOnRatingBarChangeListener(this);
        swHalfStar.setOnCheckedChangeListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if (rating >= 4){
            tvMessage.setText("Tell us how can we improve more...");
            makeVisible();
        }
        else if(rating >= 3) {
            tvMessage.setText("Tell us about your experience...");
            makeVisible();
        }
        else if (rating >= 2) {
            tvMessage.setText("Tell us what went wrong...");
            makeVisible();
        }
        else if (rating >= 1) {
            tvMessage.setText("We're sorry about you bad experience. Please tell us in detail...");
            makeVisible();
        }
    }

    private void makeVisible() {
        tvMessage.setVisibility(View.VISIBLE);
        etSuggestions.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked)
            ratingBar.setStepSize((float) 0.5);
        else
            ratingBar.setStepSize(1);

    }

    @Override
    public void onClick(View v) {

        if(ratingBar.getRating() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error!!!");
            builder.setMessage("Please Rate First!!");
            builder.setPositiveButton("Go Back", null);

            AlertDialog dialogBox = builder.create();
            dialogBox.show();
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thanks!");
            builder.setMessage("Thank You For Your Feedback!!");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tvMessage.setVisibility(View.INVISIBLE);
                    etSuggestions.setVisibility(View.INVISIBLE);
                    ratingBar.setRating(0);
                }
            });

            AlertDialog dialogBox = builder.create();
            dialogBox.show();

        }

    }
}
