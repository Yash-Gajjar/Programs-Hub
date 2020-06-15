package com.example.dynaminlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class AddData extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister ;
    Button btnCancel ;
    EditText etKey ;
    EditText etValue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        btnCancel = findViewById(R.id.btnCancel);
        btnRegister = findViewById(R.id.btnRegister);
        etKey = findViewById(R.id.etKey);
        etValue = findViewById(R.id.etValue);

        btnRegister.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRegister:

                SharedPreferences sharedPreferences = getSharedPreferences("AppShared", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(etKey.getText().toString(), etValue.getText().toString());

                editor.commit();
                break;
            default:
                this.finish();
        }

    }
}
