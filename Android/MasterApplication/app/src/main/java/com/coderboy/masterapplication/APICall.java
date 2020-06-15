package com.coderboy.masterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class APICall extends AppCompatActivity implements View.OnClickListener {

    private static final String DATABASE_URL = "http://192.168.1.11/Android/FetchData.php";
    Button btnMakeAPICall;
    ListView lstAPICall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i_call);

        btnMakeAPICall = findViewById(R.id.btnMakeAPICall);

        lstAPICall = findViewById(R.id.lstAPICall);

        btnMakeAPICall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        loadJSON();

    }

    private void loadJSON() {

        class GetJson extends AsyncTask {

            @Override
            protected Object doInBackground(Object[] objects) {

                try {
                    URL url = new URL(objects[0].toString());

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();

                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                    String jsonString;
                    while ((jsonString = bufferedReader.readLine()) != null) {
                        stringBuilder.append(jsonString + "\n");
                    }

                    return stringBuilder.toString();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return "No Data!";
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                try {
                    loadDataIntoListView(o);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        GetJson getJson = new GetJson();
        getJson.execute(DATABASE_URL);
    }

    private void loadDataIntoListView(Object o) throws JSONException {
        JSONArray jsonArray = new JSONArray(o.toString());
        ArrayList<People> people = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            people.add(new People(jsonObject.getString("firstName"), jsonObject.getString("lastName")));
        }

        CustomAdapter customAdapter = new CustomAdapter(this, people);
        lstAPICall.setAdapter(customAdapter);
    }
}