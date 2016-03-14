package com.example.divyasingh.retrofit;


import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.GET;

public interface Interface {
       @GET("/example.json")
       public void getvalue(Callback<Model> response);

}
