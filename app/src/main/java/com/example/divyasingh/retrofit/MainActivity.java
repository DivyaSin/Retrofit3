package com.example.divyasingh.retrofit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;

import retrofit.Callback;
//import retrofit.Response;
import retrofit.RestAdapter;
//import retrofit.Retrofit;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    String url = "http://jsonview.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API)
//                .build();

        Interface inter = restAdapter.create(Interface.class);
        inter.getvalue(new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {
//                model.setAwesome(JSONObject.getstring("awesome"));
                tv.setText(model.getLink());

            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("MainActivity", "Retrofit Failure");

            }
        });
    }

}


