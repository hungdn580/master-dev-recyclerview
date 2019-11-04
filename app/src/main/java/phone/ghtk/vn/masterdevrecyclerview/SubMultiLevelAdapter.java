package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SubMultiLevelAdapter extends RecyclerView.Adapter<SubMultiLevelAdapter.MyViewHolder> {
    ArrayList<SimpleRecyclerViewItem> subSimpleRecyclerViewItemArrayList;
    Context context;

    public SubMultiLevelAdapter(Context context, ArrayList<SimpleRecyclerViewItem> subSimpleRecyclerViewItemArrayList) {
        this.subSimpleRecyclerViewItemArrayList = subSimpleRecyclerViewItemArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_recyclerview_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        SimpleRecyclerViewItem simpleRecyclerViewItem = subSimpleRecyclerViewItemArrayList.get(i);
        myViewHolder.tvItem.setText(simpleRecyclerViewItem.getmName() +"");
    }

    @Override
    public int getItemCount() {
        return subSimpleRecyclerViewItemArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
