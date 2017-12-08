package com.pesteam.paditech_android_huynq_first;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bangindong on 12/8/2017.
 */

public class Screen4Adapter extends RecyclerView.Adapter<Screen4Adapter.BaseAdapter>{

    @Override
    public BaseAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    abstract class BaseAdapter extends RecyclerView.ViewHolder{

        public BaseAdapter(View itemView) {
            super(itemView);
        }

        public void BindData(int position){
            onBindingData(position);
        }

        abstract void onBindingData(int position);
    }
}
