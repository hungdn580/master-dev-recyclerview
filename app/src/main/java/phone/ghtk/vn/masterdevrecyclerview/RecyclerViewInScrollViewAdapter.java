package phone.ghtk.vn.masterdevrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewInScrollViewAdapter extends RecyclerView.Adapter<RecyclerViewInScrollViewAdapter.MyViewHolder> {
    ArrayList<SimpleRecyclerViewItem> mArrayList;

    public RecyclerViewInScrollViewAdapter(ArrayList<SimpleRecyclerViewItem> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_recyclerview_item, viewGroup ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final SimpleRecyclerViewItem simpleRecyclerViewItem = mArrayList.get(i);
        myViewHolder.tvNameItem.setText(simpleRecyclerViewItem.getmName());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
