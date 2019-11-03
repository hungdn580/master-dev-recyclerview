package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IBase;
import phone.ghtk.vn.masterdevrecyclerview.inter_.ItemTouchHelperAdapter;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public class AdapterDragAndSwipe extends RecyclerView.Adapter<AdapterDragAndSwipe.Viewholder> implements ItemTouchHelperAdapter {
    private IBase inter;
    private List<ItemBase> mItems;

    public AdapterDragAndSwipe(IBase inter, ArrayList<ItemBase> mItems) {
        this.mItems = mItems;
        this.inter = inter;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }



    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclervew_cardview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final ItemBase data=inter.getData(position);
        holder.textView.setText(data.getNumber());
    }

    @Override
    public int getItemCount() {
        return inter.getCountItem();
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        private TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_number);
        }
    }
}
