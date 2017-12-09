package com.pesteam.paditech_android_huynq_first;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_CLICK;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_NOT_WATCH;
import static com.pesteam.paditech_android_huynq_first.Screen4ChildAdapterClass.TYPE_UNCLICK;

/**
 * Created by bangindong on 12/8/2017.
 */

public class Screen4Adapter extends RecyclerView.Adapter<Screen4Adapter.BaseAdapter>{

    static final int TYPE_SECTION_1 = 0;
    static final int TYPE_SECTION_2 = 1;
    static final int TYPE_CHILD = 2;
    private ArrayList<Screen4ChildAdapterClass> list_childen = new ArrayList<>();
    private int[] list_statuses = new int[]{
            R.drawable.icon_facebook_wow,
            R.drawable.icon_facebook_like,
            R.drawable.icon_facebook_comment,
            R.drawable.icon_facebook_fb
    };

    @Override
    public BaseAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_SECTION_1:
                return new SectionAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_fist_rcv_screen4,parent,false));
            case TYPE_SECTION_2:
                return new SectionAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_notfirst_rcv_screen4,parent,false));
            case TYPE_CHILD:
                return new ChildAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_rcv_screen4,parent,false));
            default:
                return new ChildAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_rcv_screen4,parent,false));
        }

    }

    @Override
    public int getItemViewType(int position) {
        int numberNewNoti = getNumberNewNoti();
        if(position == 0){
            return TYPE_SECTION_1;
        } else if(position==(numberNewNoti+1)){
            return TYPE_SECTION_2;
        } else {
            return TYPE_CHILD;
        }
    }

    @Override
    public void onBindViewHolder(BaseAdapter holder, int position) {
        holder.BindData(position);
    }

    @Override
    public int getItemCount() {
        return (list_childen.size()+2);
    }

    abstract class BaseAdapter extends RecyclerView.ViewHolder{

        BaseAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void BindData(int position){
            onBindingData(position);
        }

        abstract void onBindingData(int position);
    }

    void addChild(Screen4ChildAdapterClass child){
        list_childen.add(child);
    }

    private int getNumberNewNoti(){
        int numberNewNoti = 0;
        for (int i = 0; i < list_childen.size(); i++) {
            if(list_childen.get(i).getAction_watch()==TYPE_NOT_WATCH){
                numberNewNoti++;
            }
        }
       return  numberNewNoti;
    }

    class SectionAdapter extends BaseAdapter{

        SectionAdapter(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }
    class ChildAdapter extends BaseAdapter{

        @BindView(R.id.background_noti)
        LinearLayout layout_background_noti;
        @BindView(R.id.text_noti_rcv_screen4)
        TextView tv_noti;
        @BindView(R.id.icon_noti)
        ImageView im_icon_noti;
        @BindView(R.id.time_noti)
        TextView tv_time_noti;

        ChildAdapter(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position_first) {
            int position = 0;
            if(position_first>0&&position_first<(getNumberNewNoti()+1)){
                position = position_first - 1;
            } else if(position_first>(getNumberNewNoti()+1)){
                position = position_first - 2;
            }
            switch (list_childen.get(position).getAction_click()){
                case TYPE_UNCLICK:
                    layout_background_noti.setBackgroundColor(itemView.getResources().getColor(R.color.back_ground_clicked_screen4));
                    break;
                case TYPE_CLICK:
                    break;
                default:

            }
            String[] list_people = list_childen.get(position).getList_people();
            String str = "";
            if(list_people.length>2){
                str = "<b>"+list_people[0]+", "+list_people[1]
                        +"</b>"+ " and "+"<b>"+ (list_people.length-2)+" other people "+"</b>"+" ";}
            else if(list_people.length==1) {
                str = "<b>"+list_people[0]+"</b>"+" ";
            } else if(list_people.length==2){
                str = "<b>"+list_people[0]+", "+list_people[1]
                        +"</b>"+ " ";
            }
            tv_noti.setText(Html.fromHtml(str+list_childen.get(position).getText()));
            im_icon_noti.setImageResource(list_statuses[list_childen.get(position).getStatus()]);
            tv_time_noti.setText(list_childen.get(position).getTime());
        }
    }
}
