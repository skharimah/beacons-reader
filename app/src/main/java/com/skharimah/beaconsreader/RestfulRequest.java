package com.skharimah.beaconsreader;

/**
 * Created by Khuram on 5/2/2016.
 */
//import com.squareup.okhttp.Call;
import com.google.gson.GsonBuilder;  // Use to Create the JSON Objects
import com.google.gson.Gson;  //  GSON Library from google
import com.google.gson.annotations.SerializedName;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.Body;
import java.io.Serializable;
import java.io.IOException;
import java.util.ArrayList;

public class RestfulRequest {


    public ArrayList<String> ResponseBody;
    public interface MyApiEndpointInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter
        
        // There are two parts to accessing the system.
        // The first part is posting just the UUID, major, and minor to the /beacon resource
        @POST("beacon/organizations/")
        Call<User> postBeacon(@Body User user);

    }


}



