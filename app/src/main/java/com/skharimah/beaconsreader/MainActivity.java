package com.skharimah.beaconsreader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skharimah.beaconsreader.RestfulRequest;
import android.bluetooth.le.BluetoothLeScanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit.Builder;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;  //  GSON coverter Library with RetroFit.
import retrofit2.Retrofit;  // Retro Fit Library
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_ENABLE_BT = 1;
    // Get an instance of device's BT adapter
    private BluetoothAdapter mBluetoothAdapter;
    // Get user email address
    public EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void onClickLogin(View view) {
        if (mBluetoothAdapter == null) {
            // Device doesn't support BT
            Toast.makeText(this, "Bluetooth not supported!",
                    Toast.LENGTH_SHORT).show();
        } else if (!mBluetoothAdapter.isEnabled()) {
            // BT adapter is not enabled
            // Request BT to be turned on
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            username = (EditText) findViewById(R.id.user_email);
            // BT exists and is enabled
            Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
            // Pass the user email information to next activity
            String userEmailAddress = username.getText().toString();
            intent.putExtra(BluetoothActivity.EXTRA_MESSAGE, userEmailAddress);
            startActivity(intent);
            getdata();
        }
    }

    public static final String BASE_URL = "https://x692mukomi.execute-api.us-east-1.amazonaws.com/test/";  // Base URL

    void getdata() {

        Gson gsonobject = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestfulRequest.MyApiEndpointInterface apiService =
                retrofit.create(RestfulRequest.MyApiEndpointInterface.class);  //
        User test = new User("email@email.com", "4152554efaab4a3b86d0947070693a77", 1, 1);  // Sample JSON to test the Web API
        Call<User> mycall = apiService.postBeacon(test);
        mycall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // Have the Output POGO Class
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}