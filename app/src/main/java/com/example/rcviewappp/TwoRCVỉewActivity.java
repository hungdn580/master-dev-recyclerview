package com.example.rcviewappp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TwoRCVỉewActivity extends AppCompatActivity {
    RecyclerView rv_parent;
    BigAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_rc_view);
        rv_parent = findViewById(R.id.rv_parent);
        titles = new ArrayList<>();
        titles.add("Number 1");
        titles.add("Number 2");
        titles.add("Number 3");
        titles.add("Number 4");
        titles.add("Number 5");


        adapter = new BigAdapter(getApplicationContext(), titles);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        rv_parent.setLayoutManager(layoutManager);
        rv_parent.setAdapter(adapter);
    }
}
