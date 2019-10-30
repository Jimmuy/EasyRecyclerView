package com.example.fixeasyrecyclerview.dome.loadmore;

import android.content.Context;
import android.view.ViewGroup;

import com.example.easyrecyclerview.adapter.BaseViewHolder;
import com.example.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.example.fixeasyrecyclerview.dome.entites.Person;
import com.example.fixeasyrecyclerview.dome.viewholder.PersonViewHolder;

/**
 * Created by Mr.Jude on 2015/7/18.
 */
public class PersonAdapter extends RecyclerArrayAdapter<Person> {
    public PersonAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(parent);
    }
}
