package com.pesteam.paditech_android_huynq_first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.STATUS_CMT;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.STATUS_FB;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.STATUS_LIKE;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.STATUS_WOW;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_CLICK;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_NOT_WATCH;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_UNCLICK;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_WATCHED;

public class Screen4Activity extends AppCompatActivity {

    Screen4Adapter Adapter = new Screen4Adapter();;
    @BindView(R.id.rcv_new_Screen4)
    RecyclerView rcv_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        ButterKnife.bind(this);
        addNewAdapter();
        addEarlierAdapter();
        rcv_new.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcv_new.setAdapter(Adapter);
    }

    private void addNewAdapter(){
        Adapter.addChild(new Screen4ChildAdapterClass(new String[]{"Nguyễn Xuân Khôi", "Mii Nhon trần","A","B","C"},
                TYPE_NOT_WATCH,
                "",
                "recently reacted to your photo.",
                STATUS_WOW,
                TYPE_UNCLICK,
                "2 hours ago"));
        Adapter.addChild(new Screen4ChildAdapterClass(new String[]{"Hiệp Lê Tuấn", "Khánh Khánh","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","E"},
                TYPE_NOT_WATCH,
                "",
                "like your photo.",
                STATUS_LIKE,
                TYPE_UNCLICK,
                "2 hours ago"));
        Adapter.addChild(new Screen4ChildAdapterClass(new String[]{"Thắng ỐC"},
                TYPE_WATCHED,
                "",
                "commented on your photo.",
                STATUS_CMT,TYPE_CLICK,
                "2 hours ago"));
        Adapter.addChild(new Screen4ChildAdapterClass(new String[]{"Mẹ Miu", "Hà Đỗ" , "A"},
                TYPE_WATCHED,
                "",
                "have their birthdays today. Let them know that you're thinking about them!",
                STATUS_FB,TYPE_UNCLICK,
                "3 hours ago"));
        Adapter.addChild(new Screen4ChildAdapterClass(new String[]{"Hiệp Lê Tuấn", "Khánh Khánh","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","E"},
                TYPE_WATCHED,
                "",
                "like your comment:\" aihihi \"",
                STATUS_LIKE,TYPE_CLICK,
                "3 hours ago"));
    }

    private void addEarlierAdapter(){

    }
}
