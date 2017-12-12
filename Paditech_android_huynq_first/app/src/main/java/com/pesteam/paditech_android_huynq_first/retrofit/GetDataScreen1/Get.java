package com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bangindong on 12/12/2017.
 */

public class Get {

    @SerializedName("section")
    @Expose
    private List<Section> section = null;

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }
}
