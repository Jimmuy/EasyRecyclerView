package com.example.fixeasyrecyclerview.dome.staggeredgrid;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyrecyclerview.EasyRecyclerView;
import com.example.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.example.easyrecyclerview.decoration.SpaceDecoration;
import com.example.easyrecyclerview.swipe.SwipeRefreshLayout;
import com.example.fixeasyrecyclerview.dome.DataProvider;
import com.example.fixeasyrecyclerview.dome.Utils;
import com.example.fixeasyrecyclerview.dome.header.BannerAdapter;
import com.jude.dome.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class StaggeredGridActivity extends AppCompatActivity {
    private EasyRecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter = new ImageAdapter(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        gridLayoutManager.setSpanSizeLookup(adapter.obtainGridSpanSizeLookUp(4));
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RollPagerView header = new RollPagerView(StaggeredGridActivity.this);
                header.setHintView(new ColorPointHintView(StaggeredGridActivity.this, Color.YELLOW,Color.GRAY));
                header.setHintPadding(0, 0, 0, (int) Utils.convertDpToPixel(8, StaggeredGridActivity.this));
                header.setPlayDelay(2000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Utils.convertDpToPixel(200, StaggeredGridActivity.this)));
                header.setAdapter(new BannerAdapter(StaggeredGridActivity.this));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        SpaceDecoration itemDecoration = new SpaceDecoration((int) Utils.convertDpToPixel(8,this));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(true);
        recyclerView.addItemDecoration(itemDecoration);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                addData();
            }

            @Override
            public void onMoreClick() {

            }
        });
        adapter.setNoMore(R.layout.view_nomore);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        adapter.addAll(DataProvider.getPictures(0));
                    }
                },1000);
            }
        });
        addData();
    }

    private void addData(){
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(DataProvider.getPictures(0));
            }
        },1000);
    }
}
