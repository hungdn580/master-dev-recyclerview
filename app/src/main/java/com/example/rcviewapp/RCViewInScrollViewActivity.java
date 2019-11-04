package com.example.rcviewapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcviewapp.adapter.Adapter;
import com.example.rcviewapp.data.Items;

import java.util.ArrayList;

public class RCViewInScrollViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Items> items;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_view_in_scroll_view);
        recyclerView = findViewById(R.id.rcViewInScrollView);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
       items = new ArrayList<>();
        for (int i =0; i<1000;i++){
            items.add(new Items("Item "+i));
        }

        adapter = new Adapter(getApplicationContext(),items);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
