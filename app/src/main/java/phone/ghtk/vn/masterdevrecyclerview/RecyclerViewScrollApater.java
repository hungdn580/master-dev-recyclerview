package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class RecyclerViewScrollApater extends RecyclerView.Adapter<RecyclerViewScrollApater.ViewHolder> {
    private Context mContext;
    private ArrayList <String> mData;

    public RecyclerViewScrollApater(Context mContext, ArrayList<String> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_activity_recycler, parent, false);
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvItem.setText(mData.get(position));
    }
    @Override
    public int getItemCount ( ) {
        return mData.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        LinearLayout linear;
        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
            linear = (LinearLayout) itemView.findViewById(R.id.linear);
        }
    }
}
