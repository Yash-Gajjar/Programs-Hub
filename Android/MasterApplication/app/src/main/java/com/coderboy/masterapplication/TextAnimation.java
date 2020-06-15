package com.coderboy.masterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class TextAnimation extends AppCompatActivity implements View.OnClickListener {

    Button btnScale, btnRotate;
    TextView tvRotate, tvScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_animation);

        btnRotate = findViewById(R.id.btnRotate);
        btnScale = findViewById(R.id.btnScale);
        tvScale = findViewById(R.id.tvScale);
        tvRotate = findViewById(R.id.tvRotate);

        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRotate:
                rotateText();
                break;
            case R.id.btnScale:
                scaleText();
                break;
        }
    }

    private void scaleText() {
        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.scale_text);

        tvScale.startAnimation(animation);
    }

    private void rotateText() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_text);

        tvRotate.startAnimation(animation);

    }
}