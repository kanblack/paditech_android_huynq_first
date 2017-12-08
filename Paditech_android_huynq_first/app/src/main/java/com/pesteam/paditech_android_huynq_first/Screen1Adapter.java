package com.pesteam.paditech_android_huynq_first;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bangindong on 12/7/2017.
 */

public class Screen1Adapter extends RecyclerView.Adapter<Screen1Adapter.BaseViewHolder> {

    private static final int TYPE_SECTION_1 = 1;
    private static final int TYPE_SECTION_2 = 2;
    private static final int TYPE_SECTION_3 = 3;
    private static final int TYPE_SECTION_4 = 4;
    private static final int TYPE_CHILD_1 = 5;
    private static final int TYPE_CHILD_2 = 6;
    private static final int TYPE_CHILD_3 = 7;
    private static final int TYPE_CHILD_4 = 8;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder;
        switch (viewType) {
            case TYPE_SECTION_1:
            case TYPE_SECTION_2:
            case TYPE_SECTION_3:
            case TYPE_SECTION_4:
                holder = new SectionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.background_text_section, parent, false));
                break;
            case TYPE_CHILD_1:
                holder = new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_1, parent, false));
                break;
            case TYPE_CHILD_2:
                holder = new RequestInsuranceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_2, parent, false));
                break;
            case TYPE_CHILD_3:
                holder = new ResearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_3, parent, false));
                break;
            case TYPE_CHILD_4:
                holder = new SupportViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_3, parent, false));
                break;
            default:
                holder = new ResearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_3, parent, false));
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return position / 2 + 1;
        } else {
            return position / 2 + 5;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(int position) {
            onBindingData(position);
        }

        abstract void onBindingData(int position);
    }

    class SectionViewHolder extends BaseViewHolder {

        @BindView(R.id.ln_text)
        LinearLayout layout;

        SectionViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("ResourceAsColor")
        @Override
        void onBindingData(int position) {
            Context context = itemView.getContext();
            switch (position / 2) {
                case 0:
                    layout.setBackgroundColor(context.getResources().getColor(R.color.section1_screen1));
                    break;
                case 1:
                    layout.setBackgroundColor(context.getResources().getColor(R.color.section2_screen1));
                    break;
                case 2:
                    layout.setBackgroundColor(context.getResources().getColor(R.color.section3_screen1));
                    break;
                case 3:
                    layout.setBackgroundColor(context.getResources().getColor(R.color.section4_screen1));
                    break;
                default:
                    layout.setBackgroundColor(context.getResources().getColor(R.color.section1_screen1));
            }
        }
    }

    class NewsViewHolder extends BaseViewHolder {

        NewsViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }

    class RequestInsuranceViewHolder extends BaseViewHolder {

        public RequestInsuranceViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }

    class ResearchViewHolder extends BaseViewHolder {

        ResearchViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }

    class SupportViewHolder extends BaseViewHolder {

        public SupportViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {

        }
    }
}
