package com.skharimah.beaconsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ApiCommunication extends AppCompatActivity {

    // Get user information from login page
    protected Intent intent;
    private String userEmailAddress;
    private String beaconUUID, beaconMajor, beaconMinor;
    public static final String USER_EMAIL = "user_email";
    public static final String IBEACON_UUID = "beacon_uuid";
    public static final String IBEACON_MAJOR = "beacon_major";
    public static final String IBEACON_MINOR = "beacon_minor";
    // ListView purposes
    String[] infoArray = {"user email", "uuid", "major", "minor"};
    private ListView listView;
    private ArrayAdapter mArrayAdapter;
    /* Debugging purposes */
    public static final String TAG = ApiCommunication.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_communication);
        // Get user & beacon information from previous activity
        intent = getIntent();
        userEmailAddress = intent.getStringExtra(USER_EMAIL);
        beaconUUID = intent.getStringExtra(IBEACON_UUID);
        beaconMajor = intent.getStringExtra(IBEACON_MAJOR);
        beaconMinor = intent.getStringExtra(IBEACON_MINOR);

        // Replace dashes in the UUID to a single string
        beaconUUID = beaconUUID.replaceAll("-", "");

        // UI
        infoArray[0] = userEmailAddress;
        infoArray[1] = "uuid: " + beaconUUID;
        infoArray[2] = "major: " + beaconMajor;
        infoArray[3] = "minor:" + beaconMinor;
        listView = (ListView) findViewById(R.id.user_beacon_info);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, infoArray);
        listView.setAdapter(mArrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ApiCommunication.this, BluetoothActivity.class);
        intent.putExtra(BluetoothActivity.EXTRA_MESSAGE, userEmailAddress);
        startActivity(intent);
    }
}
