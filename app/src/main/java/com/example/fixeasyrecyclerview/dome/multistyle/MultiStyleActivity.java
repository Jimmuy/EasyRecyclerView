package com.example.fixeasyrecyclerview.dome.multistyle;

import android.graphics.Color;
import android.os.Bundle;

import com.example.easyrecyclerview.EasyRecyclerView;
import com.example.easyrecyclerview.decoration.DividerDecoration;
import com.example.fixeasyrecyclerview.dome.DataProvider;
import com.jude.dome.R;
import com.jude.rollviewpager.Util;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by Mr.Jude on 2016/1/6.
 */
public class MultiStyleActivity extends AppCompatActivity {
    private EasyRecyclerView recyclerView;
    private PersonWithAdAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setProgressView(R.layout.view_progress);
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(this,0.5f), Util.dip2px(this,72),0);
        recyclerView.addItemDecoration(itemDecoration);
        adapter = new PersonWithAdAdapter(this);
        adapter.addAll(DataProvider.getPersonWithAds(0));
        recyclerView.setAdapterWithProgress(adapter);
    }
}
