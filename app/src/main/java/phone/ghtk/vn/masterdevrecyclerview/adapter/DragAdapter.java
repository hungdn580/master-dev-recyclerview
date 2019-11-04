package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.item;

public class DragAdapter extends RecyclerView.Adapter<DragAdapter.DragHolder> {
    private ArrayList<item> data;
    private LayoutInflater inflater;
    private Adapter.ItemClickListener itemClickListener;

    public DragAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<item> data) {
        this.data = data;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public DragHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = inflater.inflate(R.layout.item,parent,false);
        return new DragHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DragHolder holder, final int position) {
        item it =data.get(position);
        holder.bindData(it);



    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class DragHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;

        public DragHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }
        public void bindData(item it){
            tvItem.setText(it.getItem());
        }
    }
}
