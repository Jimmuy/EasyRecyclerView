package com.example.fixeasyrecyclerview.dome.insert;

import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import com.example.easyrecyclerview.EasyRecyclerView;
import com.example.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.example.easyrecyclerview.decoration.DividerDecoration;
import com.example.fixeasyrecyclerview.dome.DataProvider;
import com.example.fixeasyrecyclerview.dome.entites.Person;
import com.example.fixeasyrecyclerview.dome.loadmore.PersonAdapter;
import com.jude.dome.R;
import com.jude.rollviewpager.Util;

import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by zhuchenxi on 2016/12/12.
 */

public class InsertActivity extends AppCompatActivity {
    private EasyRecyclerView recyclerView;
    private RecyclerArrayAdapter<Person> adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(this, 0.5f), Util.dip2px(this, 72), 0);
        itemDecoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapterWithProgress(adapter = new PersonAdapter(this));
        List<Person> persons = DataProvider.getPersonList(0);
        adapter.addAll(persons.subList(0, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Random random = new Random();
        int len = adapter.getCount();
        if (len > 0) {
            int pos = random.nextInt(len);
//        int pos = 0;
            List<Person> persons = DataProvider.getPersonList(0);
            Person data = persons.get(random.nextInt(persons.size()));
            switch (item.getItemId()) {
                case R.id.ic_add:
                    adapter.insert(data, pos);
                    break;
                case R.id.ic_remove:
                    adapter.remove(pos);
                    break;
                case R.id.ic_refresh:
                    adapter.update(data, pos);
                    break;
            }
        }
        return true;
    }
}
