package com.example.seekbarratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    Button btnShow, btnRatingBar ;
    SeekBar sbRed, sbGreen, sbBlue ;
    ImageView imgColor ;
    int red, green, blue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        btnRatingBar = findViewById(R.id.btnRatingBar);
        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        imgColor = findViewById(R.id.imgColor);

        btnShow.setOnClickListener(this);
        btnRatingBar.setOnClickListener(this);
        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnShow:

                String colorCode = "Red : " +red+ " Green : " +green+ " Blue : "+blue;

                Toast.makeText(this, colorCode, Toast.LENGTH_LONG).show();
//                imgColor.setBackgroundColor(Color.rgb(red, green, blue));
                imgColor.setBackgroundColor(Color.rgb(20, 85, 52));

                break;

            case R.id.btnRatingBar:
                startActivity(new Intent(this, Ratings.class));
                finish();
                break;
        }



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sbRed:
                red = progress ;
                break;
            case R.id.sbGreen:
                green = progress ;
                break;
            case R.id.sbBlue:
                blue = progress ;
                break;
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
