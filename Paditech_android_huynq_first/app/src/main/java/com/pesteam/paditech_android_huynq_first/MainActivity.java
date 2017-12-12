package com.pesteam.paditech_android_huynq_first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pesteam.paditech_android_huynq_first.retrofit.APIService;
import com.pesteam.paditech_android_huynq_first.retrofit.APIUtils;
import com.pesteam.paditech_android_huynq_first.retrofit.Data;
import com.pesteam.paditech_android_huynq_first.retrofit.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String atoken;
    private ListView listView;
    private ArrayList<String> list_activity = new ArrayList<>();
    private Class<?>[] screens = new Class[]{
            Screen1Activity.class,
            Screen2Activity.class,
            Screen3Activity.class,
            Screen4Activity.class,
            Screen5Activity.class
    };
    private APIService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRetrofit();
        initViews();
        initData();
        setupListView();
    }

    private void testRetrofit() {
        mApiService = APIUtils.getAPIService();
    }

    private void sendPost(Integer userID, String token) {
        mApiService.saveData().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()){
                    atoken = response.body().getPost().getAccessToken();
                Log.e("onResponse: ", atoken );}
                else {
                    Log.e( "onResponse: ", "unsucess");
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("onreSponse", t.toString());
            }
        });
    }

    private void setupListView() {
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_activity);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    sendPost(1, "");
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, screens[i]);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, screens[i]);
                    startActivity(intent);
                }
            }
        });
    }

    private void initData() {
        for (Class<?> screen : screens) {
            list_activity.add(screen.getSimpleName());
        }
    }

    public void initViews() {
        listView = (ListView) findViewById(R.id.list_main);
    }
}
