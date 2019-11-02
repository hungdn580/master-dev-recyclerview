package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Interface.ItemTouchListenner;
import phone.ghtk.vn.masterdevrecyclerview.R;

public class DragAndSwipeAdapter extends RecyclerView.Adapter<DragAndSwipeAdapter.ViewHolder> implements ItemTouchListenner {

    private List<Integer> mList;

    public DragAndSwipeAdapter(List<Integer> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_demo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mText.setText(mList.get(i) + "");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onItemMove(int x, int y) {
        if (x < y) {
            for (int i = x; i < y; i++)
                Collections.swap(mList, i, i + 1);
        } else {
            for (int i = x; i > y; i--)
                Collections.swap(mList, i, i - 1);
        }
        notifyItemMoved(x, y);
    }

    @Override
    public void onItemSwipe(int x) {
        mList.remove(x);
        notifyItemRemoved(x);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mText = itemView.findViewById(R.id.txtItemNumber);
        }
    }
}
