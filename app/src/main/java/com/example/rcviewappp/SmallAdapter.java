package com.example.rcviewappp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.SmallViewHlder> {
    ArrayList<String> list;
    Context context;

    public SmallAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SmallViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_small, parent, false);
        return new SmallViewHlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmallViewHlder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SmallViewHlder extends RecyclerView.ViewHolder{
        TextView text;
        public SmallViewHlder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
