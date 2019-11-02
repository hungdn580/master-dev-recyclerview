package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Model.BaseItem;
import phone.ghtk.vn.masterdevrecyclerview.R;

public class RecyclerViewInsideRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewInsideRecyclerViewAdapter.ViewHolder> {

    private List<BaseItem> mList;

    public RecyclerViewInsideRecyclerViewAdapter(List<BaseItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sub_recyclerview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtTitle.setText(mList.get(i).getTitle());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewHolder.rcvSubItem.getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setInitialPrefetchItemCount(mList.get(i).getmList().size());

        SubRecyclerViewAdapter subRecyclerViewAdapter = new SubRecyclerViewAdapter(mList.get(i).getmList());
        viewHolder.rcvSubItem.setAdapter(subRecyclerViewAdapter);
        viewHolder.rcvSubItem.setLayoutManager(linearLayoutManager);
        viewHolder.rcvSubItem.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        RecyclerView rcvSubItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.tv_item_title);
            this.rcvSubItem = itemView.findViewById(R.id.rv_sub_item);
        }
    }
}
