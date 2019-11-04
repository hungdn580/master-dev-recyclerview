package com.example.rcviewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcviewapp.data.BigItems;
import com.example.rcviewapp.data.Items;
import com.example.rcviewapp.R;

import java.util.ArrayList;

public class BigAdapter extends RecyclerView.Adapter<BigAdapter.ViewHoler> {
    private Context mcontext;
    private ArrayList<BigItems> bigItems;
    ArrayList<Items> smallItems;

    public BigAdapter(Context mcontext, ArrayList<BigItems> bigItems) {
        this.mcontext = mcontext;
        this.bigItems = bigItems;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.item_big_rc_view, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext, RecyclerView.VERTICAL, false);
        smallItems = new ArrayList<>();
        for (int i=0;i<10;i++){
            smallItems.add(new Items("Titile "+i));
        }
       SmallAdapter smallAdapter = new SmallAdapter(mcontext,smallItems);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(smallAdapter);
        BigItems i = bigItems.get(position);
        holder.title.setText(i.getBigitems());
    }

    @Override
    public int getItemCount() {
        return bigItems.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recyclerView;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleBigRCView);
            recyclerView = itemView.findViewById(R.id.bigRCView);
        }
    }
}
