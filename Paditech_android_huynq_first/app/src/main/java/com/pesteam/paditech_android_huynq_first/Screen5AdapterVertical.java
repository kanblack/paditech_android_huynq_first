package com.pesteam.paditech_android_huynq_first;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bangindong on 12/11/2017.
 */

public class Screen5AdapterVertical extends RecyclerView.Adapter<Screen5AdapterVertical.BaseHolder> {

    public static final int STATUS_ON = 1;
    public static final int STATUS_OFF = 0;
    public static final int YOU_WATCHED = 1;
    public static final int YOU_NOT_WATCHED = 0;
    public static final int FR_WATCHED = 1;
    public static final int FR_NOT_WATCHED = 0;
    public static final int YOU_SEND = 0;
    public static final int FR_SEND = 1;
    public static final int FB_SEND = 2;

    private ArrayList<Screen5ChildAdapterVerticalClass> list_child = new ArrayList<>();
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == list_child.size()+1){
            return new lastHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_last_rcv_screen4, parent, false));
        } else {
            return new childHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_rcv_vertical_screen5, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == list_child.size()){
            return list_child.size()+1;
        } else return position;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
            holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list_child.size()+1;
    }

    abstract class BaseHolder extends RecyclerView.ViewHolder{

        BaseHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(int position){
            onBinding(position);
        }

        abstract void onBinding(int position);
    }

    void addChild(Screen5ChildAdapterVerticalClass vertical){
        list_child.add(vertical);
    }

    class childHolder extends BaseHolder {
        @BindView(R.id.icon_active_rcv_vertical_screen5)
        CircleImageView icon_active;
        @BindView(R.id.img_big_child_rcv_vertical_screen5)
        CircleImageView img_big;
        @BindView(R.id.img_small_child_rcv_vertical_screen5)
        CircleImageView img_small;
        @BindView(R.id.tv_name_child_rcv_vertical_screen5)
        TextView tv_name;
        @BindView(R.id.tv_content_rcv_vertical_screen5)
        TextView tv_content;
        @BindView(R.id.tv_time_child_rcv_vertical_screen5)
        TextView tv_time;

        childHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBinding(int position) {
                if(list_child.get(position).getStatus() == STATUS_OFF) {
                    icon_active.setVisibility(View.GONE);
                }

                if(list_child.get(position).getYouWatchedOrNot() == YOU_NOT_WATCHED){
                    tv_name.setTypeface(null, Typeface.BOLD);
                    tv_content.setTypeface(null, Typeface.BOLD);
                    tv_time.setTypeface(null, Typeface.BOLD);
                    tv_content.setTextColor(Color.BLACK);
                }

                if(list_child.get(position).getFrWatchedOrNot() == FR_WATCHED){

                } else if(list_child.get(position).getFrWatchedOrNot() == FR_NOT_WATCHED){
                    img_small.setVisibility(View.GONE);
                }

                switch (list_child.get(position).getWhoSend()){
                    case YOU_SEND:
                        tv_content.setText("You: "+list_child.get(position).getContent());
                        break;
                    case FR_SEND:
                        tv_content.setText(list_child.get(position).getContent());
                        break;
                    case FB_SEND:
                        tv_content.setText(list_child.get(position).getContent());
                        break;
                    default:

                }

                tv_name.setText(list_child.get(position).getName());
                tv_time.setText(list_child.get(position).getTime());
        }
    }

    class lastHolder extends BaseHolder {

        lastHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBinding(int position) {

        }
    }
}
