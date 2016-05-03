package com.skharimah.beaconsreader;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Khuram on 5/3/2016.
 */
public class Output {

    @SerializedName("Value")
    String mValue;

    public Output(String value) {
        this.mValue = value;
    }

}
