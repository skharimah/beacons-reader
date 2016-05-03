package com.skharimah.beaconsreader;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Khuram on 5/3/2016.
 */


//////  CLass to Create the JSON Object to post to the server.
public class User {

    @SerializedName("UUID")
    String mUUID;

    @SerializedName("UserId")
    String mEmail;

    @SerializedName("Major")
    int mMajor;

    @SerializedName("Minor")
    int mMinor;

    public User(String id, String uuid, int major, int minor) {
        this.mEmail = id;
        this.mUUID = uuid;
        this.mMajor = major;
        this.mMinor = minor;
    }
}