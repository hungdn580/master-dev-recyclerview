package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;

public class RecyclerView1000Adapter extends RecyclerView.Adapter<RecyclerView1000Adapter.RecyclerViewHolder> {
    private Context mContext;
    private List <String> data;

    public RecyclerView1000Adapter (Context mContext, List <String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_activity_recycler, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        holder.tvItem.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        LinearLayout linear;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
            linear = (LinearLayout) itemView.findViewById(R.id.linear);
        }
    }
}
