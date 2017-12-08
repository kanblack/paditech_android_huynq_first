package com.pesteam.paditech_android_huynq_first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Screen3Activity extends AppCompatActivity {

    private Screen3Adapter adapter = new Screen3Adapter();
    private ArrayList<String> list = new ArrayList<>();
    @BindView(R.id.rcvScreen3)
    RecyclerView rcvScreen3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        ButterKnife.bind(this);
        addData();
        rcvScreen3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcvScreen3.setAdapter(adapter);
    }

    private void addData() {
        adapter.addData("Finish landing page concept");
        adapter.addData("Design app illustrations");
        adapter.addData("Javascript training");
        adapter.addData("Surprise Party for Matt");
    }
}
