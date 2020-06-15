package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserNAme;
    EditText etPassword;
    Button btnLogIn;
    Button btnSignUp;

    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null && bundle.containsKey("userName")) {
            Log.d("Main activity", "User Name is: " + bundle.getString("userName"));
            temp = bundle.getString("userName");
        }
        setContentView(R.layout.activity_main);

        etUserNAme = findViewById(R.id.etUserNAme);
        etUserNAme.setText(temp);

        etPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnLogInRegister);

        btnSignUp.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);

    }

    void validateUser() {
        SharedPreferences sp = getSharedPreferences("AppPref", MODE_PRIVATE);
        String userName = sp.getString("userName","");
        String password = sp.getString("password", "");
        if (userName == "" || password == "")
            Toast.makeText(this, "No User Found!", Toast.LENGTH_SHORT).show();
        else if (etUserNAme.getText().toString().equals(userName) && etPassword.getText().toString().equals(password))
            Toast.makeText(this, "Welcome, " + userName, Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            etUserNAme.setError("Wrong Username");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                validateUser();
                break;
            case R.id.btnLogInRegister:
                this.startActivity(new Intent(this, RegisterUser.class));
                this.finish();
                break;

        }
    }
}
