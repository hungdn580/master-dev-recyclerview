package phone.ghtk.vn.masterdevrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.MyViewHolder> {
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;

    public SimpleRecyclerViewAdapter(ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList) {
        this.simpleRecyclerViewItemArrayList = simpleRecyclerViewItemArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_recyclerview_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final SimpleRecyclerViewItem simpleRecyclerViewItem = simpleRecyclerViewItemArrayList.get(i);
        myViewHolder.tvItem.setText(simpleRecyclerViewItem.getmName());
    }

    @Override
    public int getItemCount() {
        return simpleRecyclerViewItemArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
