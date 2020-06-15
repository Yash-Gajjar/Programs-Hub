package com.codeboy.registratioinloginsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText etUserName, etPassword, etConfirmPassword, etEmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        bindControls();
        btnRegister.setOnClickListener(this);

    }

    private void registerUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(etUserName.getText().toString().trim(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Email Id", etEmailId.getText().toString());
        editor.putString("UserName", etUserName.getText().toString());
        editor.putString("Password", etPassword.getText().toString());
        editor.apply();

        Toast.makeText(this, "Registration Successful!!", Toast.LENGTH_SHORT).show();

        this.startActivity(new Intent(this, MainActivity.class));
        this.finish();

    }

    private void bindControls() {
        btnRegister = findViewById(R.id.btnSignUpRegister);

        etUserName = findViewById(R.id.etSignUpUserName);
        etPassword = findViewById(R.id.etSignUpPassword);
        etConfirmPassword = findViewById(R.id.etSignUpConfirmPassword);
        etEmailId = findViewById(R.id.etSignUpEmailId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUpRegister:
                registerUser();
                break;
        }
    }
}