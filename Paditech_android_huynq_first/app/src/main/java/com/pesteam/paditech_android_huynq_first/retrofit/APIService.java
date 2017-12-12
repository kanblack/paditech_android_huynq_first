package com.pesteam.paditech_android_huynq_first.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by bangindong on 12/12/2017.
 */

public interface APIService {

    @POST("login")
    Call<Data> saveData();

    @GET("p1/getData")
    
}
