package com.coderboy.masterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Date;

public class DateAndTime extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button btnPickDate, btnPickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        btnPickDate = findViewById(R.id.btnPickDate);
        btnPickTime = findViewById(R.id.btnPickTime);

        btnPickTime.setOnClickListener(this);
        btnPickDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnPickDate:
                pickDate();
                break;

            case R.id.btnPickTime:
                pickTime();
                break;
        }

    }

    private void pickTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, 12, 00, false);
        timePickerDialog.show();
    }

    private void pickDate() {
//        The index of month starts from 0 i.e.: 0 = January, 1 = February ... 11 = December
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, 2020, 7, 21);
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String date = dayOfMonth + "-" + (month + 1) + "-" + year;
        builder.setTitle("Selected Date").setMessage("You Have selected the Date: " + date).setPositiveButton("Ok", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

//        hourOfDay always returns time in 24 hour format

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String time = hourOfDay + ":" + minute;
        builder.setTitle("Selected Time").setMessage("You Have selected the Time: " + time).setPositiveButton("Ok", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
