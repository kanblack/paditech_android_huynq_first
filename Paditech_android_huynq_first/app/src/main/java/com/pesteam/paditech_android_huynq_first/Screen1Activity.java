package com.pesteam.paditech_android_huynq_first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pesteam.paditech_android_huynq_first.retrofit.APIService;
import com.pesteam.paditech_android_huynq_first.retrofit.APIUtils;
import com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1.DataGet;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Screen1Activity extends AppCompatActivity {

    APIService mApiService = APIUtils.getAPIService();
    @BindView(R.id.rcvMain)
    RecyclerView rcvMain;
    Screen1Adapter screen1Adapter = new Screen1Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_1);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String token = intent.getStringExtra("access_token");
        getDataScreen1(token);
    }

    private void getDataScreen1(String access_token){
        mApiService.loadData(access_token).enqueue(new Callback<DataGet>() {
            @Override
            public void onResponse(Call<DataGet> call, Response<DataGet> response) {
                if(response.isSuccessful()){
                    screen1Adapter.setGet(response.body().getData());
                    Log.e( "onResponse: ", response.body().getData().getSection().size()+"");
                    rcvMain.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
                    rcvMain.setAdapter(screen1Adapter);
                }
                else {
                    Log.e( "onResponse: ", "unsucess");
                }
            }

            @Override
            public void onFailure(Call<DataGet> call, Throwable t) {
                Log.e("onreSponse", t.toString());
            }
        });
    }
}
