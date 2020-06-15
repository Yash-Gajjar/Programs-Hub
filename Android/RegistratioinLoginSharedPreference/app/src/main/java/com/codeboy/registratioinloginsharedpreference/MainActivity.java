package com.codeboy.registratioinloginsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogIn, btnSignUp;
    EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindControls();

        btnLogIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private void bindControls() {
        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnLogInSignUp);

        etUserName = findViewById(R.id.etLogInUserName);
        etPassword = findViewById(R.id.etLogInPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogIn:
                validateUser();
                break;
            case R.id.btnLogInSignUp:
                this.startActivity(new Intent(this, Registration.class));
                this.finish();
                break;
        }
    }

    private void validateUser() {

        SharedPreferences sharedPreferences = getSharedPreferences(etUserName.getText().toString().trim(), MODE_PRIVATE);

        if (!etUserName.getText().toString().trim().equals("")) {
            if (etUserName.getText().toString().equals(sharedPreferences.getString("UserName", "")) &&
                    etPassword.getText().toString().equals(sharedPreferences.getString("Password", ""))) {
                Toast.makeText(this, "Welcome, " + etUserName.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No User Found!!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            etUserName.setError("UserName Can't Be Black!");
        }
    }
}