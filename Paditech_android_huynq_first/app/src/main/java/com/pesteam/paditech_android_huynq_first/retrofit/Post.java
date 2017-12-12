package com.pesteam.paditech_android_huynq_first.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bangindong on 12/12/2017.
 */

public class Post {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("access_token")
    @Expose
    private String accessToken;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "Post{" +
                " id_user = "+userId+
                " access_token"+accessToken+"}";
    }
}
