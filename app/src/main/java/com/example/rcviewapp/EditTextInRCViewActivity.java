package com.example.rcviewapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcviewapp.adapter.EditTextRCViewAdapter;
import com.example.rcviewapp.data.Items;

import java.util.ArrayList;

public class EditTextInRCViewActivity  extends AppCompatActivity {
    RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
    ArrayList<Items> items;
    EditTextRCViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitty_edit_text_in_rc_view);
        recyclerView = findViewById(R.id.editTextInRCView);
        items = new ArrayList<>();
        for (int i =0; i<10;i++){
            items.add(new Items("Item "+i));
        }

        adapter = new EditTextRCViewAdapter(getApplicationContext(),items);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemViewCacheSize(items.size());
    }
}
