package com.example.apicall;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String DATABASE_URL = "http://192.168.1.10/Android/FetchData.php";
    Button btnReresh ;
    ListView lstData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReresh = findViewById(R.id.btnRefresh) ;
        lstData = findViewById(R.id.lstData) ;

        btnReresh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRefresh:
                loadJSON(DATABASE_URL);
                break;
        }

        /*ArrayList<TempClass> arrClassObjs = new ArrayList<>();
        arrClassObjs.add(new TempClass("Yash", "Gajjar"));
        arrClassObjs.add(new TempClass("Harsh", "Patel"));
        arrClassObjs.add(new TempClass("Devansh", "Damani"));

        CustomAdapter customAdapter = new CustomAdapter(this, arrClassObjs);

        lstData.setAdapter(customAdapter);*/

    }

    private void loadJSON(final String databaseUrl) {

        class GetJson extends AsyncTask{

            @Override
            protected String doInBackground(Object[] objects) {


                /*
                * if(byGetOrPost == 0){ //means by Get Method

                     try{
                        String username = (String)arg0[0];
                        String password = (String)arg0[1];
                        String link = "http://myphpmysqlweb.hostei.com/login.php?username="+username+"& password="+password;

                        URL url = new URL(link);
                        HttpClient client = new DefaultHttpClient();
                        HttpGet request = new HttpGet();
                        request.setURI(new URI(link));
                        HttpResponse response = client.execute(request);
                        BufferedReader in = new BufferedReader(new
                           InputStreamReader(response.getEntity().getContent()));

                        StringBuffer sb = new StringBuffer("");
                        String line="";

                        while ((line = in.readLine()) != null) {
                           sb.append(line);
                           break;
                        }

                        in.close();
                        return sb.toString();
                     } catch(Exception e){
                        return new String("Exception: " + e.getMessage());
                     }
                  }
                * */

                try {
                    URL url = new URL(objects[0].toString());
//                    Log.d("From Main: ", "URL String Is: "+url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                   /* httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setConnectTimeout(15000);
*/
                    httpURLConnection.connect();
//                    Log.d("From Main: ", "Connected");
                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                    String jsonString ;

//                    Log.d("From Main: ", "Before While Loop!");
                    while((jsonString = bufferedReader.readLine()) != null)
                        stringBuilder.append(jsonString + "\n");

//                    Log.d("From Main: ", "String Builder String Is: "+stringBuilder.toString());

                    return stringBuilder.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
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

//        Log.d("From LoadData: ", "Object Value: " + o.toString());
/*

        JSONObject jsonObject = new JSONObject(String.valueOf(o));

        Log.d("From Main: ", "First Name: "+jsonObject.getString("firstName"));
        Log.d("From Main: ", "Last Name: "+jsonObject.getString("lastName"));
*/


        JSONArray jsonArray = new JSONArray(o.toString());
        ArrayList<TempClass> people = new ArrayList<>();


        /* JSONArray jsonArray = jsnobject.getJSONArray("locations");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
        }
        */



        for(int i = 0; i<jsonArray.length();i++) {

            JSONObject jsonOBJ = jsonArray.getJSONObject(i);

            String firstName = jsonOBJ.getString("firstName");

            String lastName = jsonOBJ.getString("lastName");
            people.add(new TempClass(firstName, lastName));
        }

        CustomAdapter customAdapter = new CustomAdapter(this, people);
        lstData.setAdapter(customAdapter);

    }
}
