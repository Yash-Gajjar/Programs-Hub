package com.coderboy.masterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstTopics;
    Class[] topicsActivities = {RatingBarDemo.class, SeekBarRGBColour.class, DateAndTime.class, TextAnimation.class, APICall.class, ContentProvider.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTopics = findViewById(R.id.lstTopics);

        lstTopics.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        <array name="list_topic">
            <item>RatingBar</item>
            <item>SeekBar RGB color</item>
            <item>Date and Time</item>
            <item>Text Animation</item>
            <item>API Call</item>
            <item>Content Provider</item>
            <item>Content Provider - Contacts</item>
        </array>
        */

        this.startActivity(new Intent(this, topicsActivities[position]));

    }
}