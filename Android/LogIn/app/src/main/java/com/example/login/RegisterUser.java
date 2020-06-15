package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Button btnSignUp ;
    RadioGroup rbgGender ;
    EditText etUserName ;
    EditText etPassword ;
    EditText etMobileNumber ;
    CheckBox cbRememberMe ;
    boolean isRememberMe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        btnSignUp = findViewById(R.id.btnSignUp);
        rbgGender = findViewById(R.id.rbgGender);
        etUserName = findViewById(R.id.etRegisterUserName);
        etPassword = findViewById(R.id.etRegisterPassword);
        etMobileNumber = findViewById(R.id.etRegisterMobileNumber);
        cbRememberMe = findViewById(R.id.cbRememberMe);

        btnSignUp.setOnClickListener(this);
        cbRememberMe.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp = getSharedPreferences("AppPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName", etUserName.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
        if (isRememberMe){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userName", etUserName.getText().toString());
            this.startActivity(intent);
            this.finish();
        } else {
            this.startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isRememberMe = isChecked;
    }
}
