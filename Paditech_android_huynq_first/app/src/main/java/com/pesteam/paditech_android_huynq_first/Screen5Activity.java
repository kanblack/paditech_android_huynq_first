package com.pesteam.paditech_android_huynq_first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Screen5Activity extends AppCompatActivity {

    @BindView(R.id.rcv_vertical_screen5)
    RecyclerView rcv_vertical;
    @BindView(R.id.rcv_horizonal_screen5)
    RecyclerView rcv_horizonal;
    Screen5AdapterVertical adapterVertical = new Screen5AdapterVertical();
    Screen5AdapterHorizontal adapterHorizontal = new Screen5AdapterHorizontal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);
        ButterKnife.bind(this);
        addVerticalAdapter();
        addHorizontalAdapter();
        rcv_horizonal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcv_vertical.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rcv_vertical.setAdapter(adapterVertical);
        rcv_horizonal.setAdapter(adapterHorizontal);
    }

    private void addHorizontalAdapter() {
        adapterHorizontal.addChild(new Screen5ChildAdapterHorizontalClass("",1,"Nguyen"));
        adapterHorizontal.addChild(new Screen5ChildAdapterHorizontalClass("",0,"Trangg"));
        adapterHorizontal.addChild(new Screen5ChildAdapterHorizontalClass("",1,"Phong"));
        adapterHorizontal.addChild(new Screen5ChildAdapterHorizontalClass("",1,"Ju"));
    }

    private void addVerticalAdapter() {
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",0,"Just You","You sent a photo.",1,0,0,"13:53"));
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",1,"Nê","",1,1,0,"13:44"));
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",0,"Chelsea Tiến","ok ông", 1,1,0,"10:28"));
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",0,"Tiến Đức Vũ","Các bạn hiện đã được kết nối trên Messege",0,0,2,"Sun"));
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",0,"Thanh Long Mai","Dạo này bạn hả ông bạn :)))",0,1,1,"Sun"));
        adapterVertical.addChild(new Screen5ChildAdapterVerticalClass("",0,"Lê Hiệp","Ok",1,0,1,"Sun"));
    }


}
