package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;


public class AdapterRecyclerviewChild extends RecyclerView.Adapter<AdapterRecyclerviewChild.ViewHolderChild> {
    private List<ItemBase> mItems;


    public AdapterRecyclerviewChild(List<ItemBase> mItems) {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public ViewHolderChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_line,parent,false);
        return new ViewHolderChild(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChild holder, int position) {
        holder.mTextSub.setText(mItems.get(position).getNumber() + "");
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static public class ViewHolderChild extends RecyclerView.ViewHolder {
        private TextView mTextSub;

        public ViewHolderChild(@NonNull View itemView) {
            super(itemView);
            mTextSub=itemView.findViewById(R.id.tv_number);
        }
    }
}
