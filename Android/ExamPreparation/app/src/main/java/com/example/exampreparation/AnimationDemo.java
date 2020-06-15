package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimationDemo extends AppCompatActivity {

    TextView tvAnimationText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        tvAnimationText = findViewById(R.id.tvAnimationText) ;

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);;

//        tvAnimationText.setAnimation(fadeInAnimation);
        tvAnimationText.startAnimation(fadeInAnimation);

    }
}
