package com.pesteam.paditech_android_huynq_first;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bangindong on 12/8/2017.
 */

public class Screen3Adapter extends RecyclerView.Adapter<Screen3Adapter.BaseViewHolder> {

    private ArrayList<String> listWork = new ArrayList<>();
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder;
        baseViewHolder = new ViewChild(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_inside_recycview_screen3,parent,false));
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listWork.size();
    }

    public void myAdapter(ArrayList<String> list){
        listWork = list;
    }

    public void addData(String data){
        listWork.add(data);
    }

    abstract class BaseViewHolder extends RecyclerView.ViewHolder{


        BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(int position){
            onBinding(position);
        }

        abstract void onBinding(int position);
    }

    class ViewChild extends BaseViewHolder{

        @BindView(R.id.text_inview_inrecycleview)
        TextView tV;

        public ViewChild(View itemView) {
            super(itemView);
        }

        @Override
        void onBinding(int position) {
            tV.setText(listWork.get(position));
        }
    }
}
