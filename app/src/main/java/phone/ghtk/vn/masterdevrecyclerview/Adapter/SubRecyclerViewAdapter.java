package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;

public class SubRecyclerViewAdapter extends RecyclerView.Adapter<SubRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mList;

    public SubRecyclerViewAdapter(List<Integer> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rcv_demo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextSub.setText(mList.get(i) + "");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextSub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTextSub = itemView.findViewById(R.id.txtItemNumber);
        }
    }
}
