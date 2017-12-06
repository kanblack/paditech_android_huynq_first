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

    ListView listView;
    ArrayList<String> list_activity = new ArrayList<>();
    Class<?>[] screens = new Class[]{
            Screen_1.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        for(int i = 0; i<screens.length;i++){
            Class<?> screen = screens[i];
            list_activity.add(screen.getSimpleName());
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list_activity);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, screens[i]);
            }
        });
    }

    public void init(){
        listView = (ListView) findViewById(R.id.list_main);
    }
}
