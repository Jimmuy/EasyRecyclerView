package com.example.fixeasyrecyclerview.dome.staggeredgrid;

import android.content.Context;
import android.view.ViewGroup;

import com.example.easyrecyclerview.adapter.BaseViewHolder;
import com.example.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.example.fixeasyrecyclerview.dome.entites.Picture;
import com.example.fixeasyrecyclerview.dome.viewholder.ImageViewHolder;

/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class ImageAdapter extends RecyclerArrayAdapter<Picture> {
    public ImageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(parent);
    }
}
