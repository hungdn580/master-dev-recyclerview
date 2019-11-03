package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IBase;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public class AdapterFragmentBase extends RecyclerView.Adapter<AdapterFragmentBase.BaseViewHolder> {
    private IBase inter;
    private List<ItemBase> list;


    public AdapterFragmentBase(IBase inter,ArrayList<ItemBase> listItem) {
        this.inter = inter;
        this.list=listItem;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclervew_cardview,parent,false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        final ItemBase data=inter.getData(position);
        holder.number.setText(data.getNumber());
    }

    @Override
    public int getItemCount() {
        return inter.getCountItem();
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder{
        private TextView number;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.tv_number);
        }
    }
}
