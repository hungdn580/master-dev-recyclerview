package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;

public class NumberListAdapter extends RecyclerView.Adapter<NumberListAdapter.ViewHolder> {

    private List<Integer> mList;

    public NumberListAdapter(List<Integer> mList) {
        this.mList = mList;
    }

    @Override
    public NumberListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_demo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumberListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txtNumber.setText(mList.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            this.txtNumber = itemView.findViewById(R.id.txtItemNumber);
        }
    }
}
