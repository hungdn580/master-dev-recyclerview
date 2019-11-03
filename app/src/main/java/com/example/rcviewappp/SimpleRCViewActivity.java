package com.example.rcviewappp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleRCViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Items> items;
    RcViewApdapter simpleRcViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiner_recycle_view);
        recyclerView = (RecyclerView) findViewById(R.id.simpleRcView);
        items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Items("Item " + i));
        }
        simpleRcViewAdapter = new RcViewApdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        recyclerView.setAdapter(simpleRcViewAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}
