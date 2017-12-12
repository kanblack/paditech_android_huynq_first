package com.pesteam.paditech_android_huynq_first.retrofit;

/**
 * Created by bangindong on 12/12/2017.
 */

public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "https://demo0858711.mockable.io/";

    public static APIService getAPIService(){

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
