package phone.ghtk.vn.masterdevrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class DragSwipeAdapter extends RecyclerView.Adapter<DragSwipeAdapter.MyViewHolder>  {
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;

    public DragSwipeAdapter(ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList) {
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
        myViewHolder.tvName.setText(simpleRecyclerViewItem.getmName());
    }

    @Override
    public int getItemCount() {
        return simpleRecyclerViewItemArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItem);
        }
    }
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(simpleRecyclerViewItemArrayList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(simpleRecyclerViewItemArrayList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public void swipe(int position, int direction) {
        simpleRecyclerViewItemArrayList.remove(position);
        notifyItemRemoved(position);
    }
}
