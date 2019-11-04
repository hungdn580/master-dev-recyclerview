package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ParentMultiLevelAdapter extends RecyclerView.Adapter<ParentMultiLevelAdapter.MyViewHolder> {
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;
    Context context ;

    public ParentMultiLevelAdapter(ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList) {
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
        ArrayList<SimpleRecyclerViewItem> subMultiLevelSimpleRecyclerViewItemArrayList = new ArrayList<SimpleRecyclerViewItem>();
        for ( int j = 0; j < 10; j++) {
            subMultiLevelSimpleRecyclerViewItemArrayList.add(new SimpleRecyclerViewItem("Item" + j));
        }
        SimpleRecyclerViewItem simpleRecyclerViewItem = subMultiLevelSimpleRecyclerViewItemArrayList.get(i);
        myViewHolder.tvItem.setText(simpleRecyclerViewItem.getmName());
        SubMultiLevelAdapter subMultiLevelAdapter = new SubMultiLevelAdapter(context,subMultiLevelSimpleRecyclerViewItemArrayList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.recyclerView.setLayoutManager(layoutManager);
        myViewHolder.recyclerView.setAdapter(subMultiLevelAdapter);

    }

    @Override
    public int getItemCount() {
        return simpleRecyclerViewItemArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
            recyclerView = itemView.findViewById(R.id.rvSub);
        }
    }

}
