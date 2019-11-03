package com.example.rcviewappp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RcViewApdapter extends RecyclerView.Adapter<RcViewApdapter.ViewHolder >  {
    public TextView textView;
    // Contructor items
    private ArrayList<Items> item;

    public RcViewApdapter(ArrayList<Items> item) {
        this.item = item;
    }

    @NonNull
    @Override
    // định nghĩa item layout và khởi tạo holder
    public RcViewApdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.activity_items, parent, false);

        return new ViewHolder(contactView);

    }
    // thiết lập các thuộc tính củA View và dữ liệu
    @Override
    public void onBindViewHolder(@NonNull RcViewApdapter.ViewHolder holder, int position) {
        holder.textView.setText ( item.get ( position ).getName ());

    }

    // đếm số item trong listdata
    @Override
    public int getItemCount() {
        return item.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            textView = itemView.findViewById ( R.id.simpleRcViewItem );
        }
    }
}
