package com.pesteam.paditech_android_huynq_first.retrofit;

import com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1.DataGet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by bangindong on 12/12/2017.
 */

public interface APIService {

    @POST("login")
    Call<DataPost> saveData();

    @GET("p1/getData")
    Call<DataGet> loadData(@Query("heaher") String access_token);
}
