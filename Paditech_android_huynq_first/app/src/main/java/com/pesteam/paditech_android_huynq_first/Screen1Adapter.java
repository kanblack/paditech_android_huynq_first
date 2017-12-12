package com.pesteam.paditech_android_huynq_first;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1.DataGet;
import com.pesteam.paditech_android_huynq_first.retrofit.GetDataScreen1.Get;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

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
    private Get get = new Get();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder;
        switch (viewType) {
            case TYPE_SECTION_1:
            case TYPE_SECTION_2:
            case TYPE_SECTION_3:
            case TYPE_SECTION_4:
                holder = new SectionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section_rcv_screen1, parent, false));
                break;
            case TYPE_CHILD_1:
                holder = new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child1_rcv_screen1, parent, false));
                break;
            case TYPE_CHILD_2:
                holder = new RequestInsuranceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child2_rcv_screen1, parent, false));
                break;
            case TYPE_CHILD_3:
                holder = new ResearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child3_rcv_screen1, parent, false));
                break;
            case TYPE_CHILD_4:
                holder = new ResearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child3_rcv_screen1, parent, false));
                break;
            default:
                holder = new ResearchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child3_rcv_screen1, parent, false));
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
        return get.getSection().size()*2;
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
        @BindView(R.id.tx_title_section_screen1)
        TextView tv_title;

        SectionViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("ResourceAsColor")
        @Override
        void onBindingData(int position) {
            tv_title.setText(get.getSection().get(position/2).getTitle());
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

        @BindView(R.id.im_big_section1_screen1)
        ImageView im_big;
        @BindView(R.id.im_small_top_section1_screen1)
                ImageView im_small_top;
        @BindView(R.id.im_small_bottom_section1_screen1)
                ImageView im_small_bottom;
        @BindView(R.id.textView)
                TextView title_big;
        @BindView(R.id.textView2)
                TextView short_descrip_big;
        @BindView(R.id.textView3)
                TextView title_small_top;
        @BindView(R.id.textView4)
                TextView title_small_bottom;

        NewsViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(0).getUrl()).into(im_big);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(1).getUrl()).into(im_small_top);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(2).getUrl()).into(im_small_bottom);
            title_big.setText(get.getSection().get((position-1)/2).getImages().get(0).getTitle());
            short_descrip_big.setText(get.getSection().get((position-1)/2).getImages().get(0).getShortDescription());
            title_small_top.setText(get.getSection().get((position-1)/2).getImages().get(1).getTitle());
            title_small_bottom.setText(get.getSection().get((position-1)/2).getImages().get(2).getTitle());
        }
    }

    class RequestInsuranceViewHolder extends BaseViewHolder {

        @BindView(R.id.img_top_left_section2)
                ImageView img_top_left;
        @BindView(R.id.img_top_right_section2)
        ImageView img_top_right;
        @BindView(R.id.img_bottom_left_section2)
        ImageView img_bottom_left;
        @BindView(R.id.img_bottom_right_section2)
        ImageView img_bottom_right;
        @BindView(R.id.tex_top_left_section2)
        TextView tex_top_left;
        @BindView(R.id.tex_top_right_section2)
        TextView tex_top_right;
        @BindView(R.id.tex_bottom_left_section2)
        TextView tex_bottom_left;
        @BindView(R.id.tex_bottom_right_section2)
        TextView tex_bottom_right;

        RequestInsuranceViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(0).getUrl()).into(img_top_left);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(1).getUrl()).into(img_top_right);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(2).getUrl()).into(img_bottom_left);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(3).getUrl()).into(img_bottom_right);
            tex_top_left.setText(get.getSection().get((position-1)/2).getImages().get(0).getTitle());
            tex_top_right.setText(get.getSection().get((position-1)/2).getImages().get(1).getTitle());
            tex_bottom_left.setText(get.getSection().get((position-1)/2).getImages().get(2).getTitle());
            tex_bottom_right.setText(get.getSection().get((position-1)/2).getImages().get(3).getTitle());
        }
    }

    class ResearchViewHolder extends BaseViewHolder {

        @BindView(R.id.cic_left_section3_screen1)
        CircleImageView cic_left;
        @BindView(R.id.cic_center_section3_screen1)
        CircleImageView cic_center;
        @BindView(R.id.cic_right_section3_screen1)
        CircleImageView cic_right;
        @BindView(R.id.tex_left_section3_screen1)
        TextView tex_left;
        @BindView(R.id.tex_center_section3_screen1)
        TextView tex_center;
        @BindView(R.id.tex_right_section3_screen1)
        TextView tex_right;

        ResearchViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        void onBindingData(int position) {
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(0).getUrl()).into(cic_left);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(1).getUrl()).into(cic_center);
            Picasso.with(itemView.getContext()).load(get.getSection().get((position-1)/2).getImages().get(2).getUrl()).into(cic_right);
            tex_left.setText(get.getSection().get((position-1)/2).getImages().get(0).getTitle());
            tex_center.setText(get.getSection().get((position-1)/2).getImages().get(1).getTitle());
            tex_right.setText(get.getSection().get((position-1)/2).getImages().get(2).getTitle());
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

    public Get getGet() {
        return get;
    }

    public void setGet(Get get) {
        this.get = get;
    }
}
