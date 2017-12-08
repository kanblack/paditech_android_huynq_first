package com.pesteam.paditech_android_huynq_first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> list_activity = new ArrayList<>();
    private Class<?>[] screens = new Class[]{
            Screen1Activity.class,
            Screen2Activity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        setupListView();
    }

    private void setupListView() {
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list_activity);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, screens[i]);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        for (Class<?> screen : screens) {
            list_activity.add(screen.getSimpleName());
        }
    }

    public void initViews(){
        listView = (ListView) findViewById(R.id.list_main);
    }
}
