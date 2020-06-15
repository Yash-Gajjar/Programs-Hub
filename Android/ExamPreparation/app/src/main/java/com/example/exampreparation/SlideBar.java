package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SlideBar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBar ;
    TextView tvSeekBarValue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_bar);

        seekBar = findViewById(R.id.seekBar) ;
        tvSeekBarValue = findViewById(R.id.tvSeekBarValue) ;

        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvSeekBarValue.setText("Value of Progress Bar: " + progress);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
