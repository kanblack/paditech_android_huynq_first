package com.pesteam.paditech_android_huynq_first;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.pavlospt.CircleView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bangindong on 12/11/2017.
 */

public class Screen5AdapterHorizontal extends RecyclerView.Adapter<Screen5AdapterHorizontal.BaseHolder> {

    public static final int STATUS_ONL = 1;
    public static final int STATUS_OFF = 0;
    public static final int CHILD_FIRST = 0;

    private ArrayList<Screen5ChildAdapterHorizontalClass> list_child = new ArrayList<>();
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==CHILD_FIRST){
            return new childFirstHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_first_rcv_horizontal_screen5,parent,false));
        } else {
            return new childNotFirstHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_rcv_horizontal_screen5,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return CHILD_FIRST;
                default:
                    return position;
        }
    }

    @Override
    public int getItemCount() {
        return list_child.size()+1;
    }

    //todo: rename class to holder
    abstract class BaseHolder extends RecyclerView.ViewHolder{

        BaseHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bindData(int position){
            onBindingData(position);
        }

        abstract void onBindingData(int position);
    }

    void addChild(Screen5ChildAdapterHorizontalClass horizontal){
        list_child.add(horizontal);
    }

    //TODO: rename class
    class childNotFirstHolder extends BaseHolder {

        @BindView(R.id.big_img_rcv_horizontal_screen5)
        CircleImageView big_img;
        @BindView(R.id.small_img_rcv_horizontal_screen5)
        CircleImageView small_img;
        @BindView(R.id.icon_onl_or_not_rcv_horizontal_screen5)
        CircleView icon_onl_or_not;
        @BindView(R.id.tv_name_rcv_horizontal_screen5)
        TextView tv_name;
        public childNotFirstHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {
                if(list_child.get(position-1).getStatus() == STATUS_OFF){
                    small_img.setVisibility(View.GONE);
                    icon_onl_or_not.setVisibility(View.GONE);
                    big_img.setBackground(null);
                }
                tv_name.setText(list_child.get(position-1).getName());
        }
    }

    //TODO: rename class
    class childFirstHolder extends BaseHolder {

        childFirstHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }
}
