package com.pesteam.paditech_android_huynq_first.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bangindong on 12/12/2017.
 */

public class Data {

    @SerializedName("data")
    @Expose
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
