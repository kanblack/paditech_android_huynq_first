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

/**
 * Created by bangindong on 12/8/2017.
 */

public class Screen3Adapter extends RecyclerView.Adapter<Screen3Adapter.BaseViewHolder> {

    private int[] color = new int[]{
            R.color.cicrle1_mini_screen3,
            R.color.cicrle2_mini_screen3,
            R.color.cicrle3_mini_screen3,
            R.color.cicrle4_mini_screen3,
    };
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

    void addData(String data){
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
        @BindView(R.id.cicrleview)
        CircleView ccv;
        @BindView(R.id.view_line_last_screen3)
                View view;
        ViewChild(View itemView) {
            super(itemView);
        }

        @Override
        void onBinding(int position) {
            tV.setText(listWork.get(position));
            if(position == (listWork.size()-1)){
                view.setVisibility(View.GONE);
            }

            ccv.setBackgroundColor(itemView.getContext().getResources().getColor(color[position%4]));
            ccv.setFillColor(itemView.getContext().getResources().getColor(color[position%4]));
            ccv.setStrokeColor(itemView.getContext().getResources().getColor(color[position%4]));
        }
    }
}
