package com.example.rcviewappp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BigAdapter extends RecyclerView.Adapter<BigAdapter.BigViewHolder> {
    Context context;
    ArrayList<String> titles;

    public BigAdapter(Context context, ArrayList<String> titles) {
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public BigViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_big, parent, false);
        return new BigViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BigViewHolder holder, int position) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        list.add("Item 6");
        list.add("Item 7");
        list.add("Item 8");
        SmallAdapter adapter = new SmallAdapter(list, context);
        holder.rv.setLayoutManager(layoutManager);
        holder.rv.setAdapter(adapter);
        holder.tv.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class BigViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rv;
        TextView tv;
        public BigViewHolder(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.big);
            tv = itemView.findViewById(R.id.title);
        }
    }
}
