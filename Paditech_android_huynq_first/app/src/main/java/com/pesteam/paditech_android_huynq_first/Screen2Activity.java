package com.pesteam.paditech_android_huynq_first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.pesteam.paditech_android_huynq_first.retrofit.APIService;
import com.pesteam.paditech_android_huynq_first.retrofit.APIUtils;
import com.pesteam.paditech_android_huynq_first.retrofit.DataPost;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Screen2Activity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    Button btn_login;

    private String atoken;
    private APIService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        ButterKnife.bind(this);
        mApiService = APIUtils.getAPIService();
        login();
    }

    private void login(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPost(1, "");
                Intent intent = new Intent();
                intent.putExtra("access_token",atoken);
                intent.setClass(Screen2Activity.this, Screen1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void sendPost(Integer userID, String token) {
        mApiService.saveData().enqueue(new Callback<DataPost>() {
            @Override
            public void onResponse(Call<DataPost> call, Response<DataPost> response) {
                if(response.isSuccessful()){
                    atoken = response.body().getPost().getAccessToken();
                    Log.e("onResponse: ", atoken );
                }
                else {
                    Log.e( "onResponse: ", "unsucess");
                }
            }

            @Override
            public void onFailure(Call<DataPost> call, Throwable t) {
                Log.e("onreSponse", t.toString());
            }
        });
    }
}
