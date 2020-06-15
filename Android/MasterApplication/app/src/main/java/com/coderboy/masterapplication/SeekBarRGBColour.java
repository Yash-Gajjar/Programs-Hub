package com.coderboy.masterapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SeekBarRGBColour extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    Button btnDcrRed, btnIncRed;
    Button btnDcrGreen, btnIncGreen;
    Button btnDcrBlue, btnIncBlue;
    Button btnReset, btnShowColorCode;
    ImageView imgColor;
    SeekBar sbRed, sbGreen, sbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_r_g_b_colour);

        bindControlsAndListeners();
    }

    private void bindControlsAndListeners() {

        btnDcrRed = findViewById(R.id.btnDcrRed);
        btnIncRed = findViewById(R.id.btnIncRed);
        btnDcrGreen = findViewById(R.id.btnDcrGreen);
        btnIncGreen = findViewById(R.id.btnIncGreen);
        btnDcrBlue = findViewById(R.id.btnDcrBlue);
        btnIncBlue = findViewById(R.id.btnIncBlue);
        btnReset = findViewById(R.id.btnReset);
        btnShowColorCode = findViewById(R.id.btnShowColorCode);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        imgColor = findViewById(R.id.ivColor);

        btnDcrRed.setOnClickListener(this);
        btnIncRed.setOnClickListener(this);
        btnDcrGreen.setOnClickListener(this);
        btnIncGreen.setOnClickListener(this);
        btnDcrBlue.setOnClickListener(this);
        btnIncBlue.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnShowColorCode.setOnClickListener(this);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDcrRed:
                sbRed.setProgress( sbRed.getProgress() - 1 );
                setColor() ;
                break ;
            case R.id.btnIncRed:
                sbRed.setProgress( sbRed.getProgress() + 1 );
                setColor() ;
                break ;
            case R.id.btnDcrGreen:
                sbGreen.setProgress( sbGreen.getProgress() - 1);
                setColor() ;
                break ;
            case R.id.btnIncGreen:
                sbGreen.setProgress( sbGreen.getProgress() + 1);
                setColor() ;
                break ;
            case R.id.btnDcrBlue:
                sbBlue.setProgress( sbBlue.getProgress() - 1);
                setColor() ;
                break ;
            case R.id.btnIncBlue:
                sbBlue.setProgress( sbBlue.getProgress() + 1);
                setColor() ;
                break ;
            case R.id.btnReset:
                sbRed.setProgress(0);
                sbGreen.setProgress(0);
                sbBlue.setProgress(0);
                imgColor.setBackgroundColor(getColor(R.color.colorBlack));
                break ;
            case R.id.btnShowColorCode:
                showColorCodeDialog() ;
                break ;

        }
    }

    private void showColorCodeDialog() {

//        Building an Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
        String message = "Red: " +sbRed.getProgress()+"\nGreen: "+sbGreen.getProgress()+"\nBlue: "+sbBlue.getProgress() ;
        builder.setTitle("Colour Code");
        builder.setMessage(message) ;
        builder.setPositiveButton("Ok",null);

//        Displaying Alert Dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setColor() {
//        Setting Colour in the ImageVIew
//        using the static rgb() method of the Color class
//        Passing values of Seekbars
        imgColor.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//        This method gets executed every time user changes any of the seekbar
        setColor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}