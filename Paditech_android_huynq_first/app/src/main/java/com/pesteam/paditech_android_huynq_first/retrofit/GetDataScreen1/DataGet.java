package com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bangindong on 12/12/2017.
 */

public class DataGet {
    @SerializedName("data")
    @Expose
    private Get data;

    public Get getData() {
        return data;
    }

    public void setData(Get data) {
        this.data = data;
    }
}
