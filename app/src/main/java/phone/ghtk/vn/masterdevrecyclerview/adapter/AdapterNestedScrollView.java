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

public class AdapterNestedScrollView extends RecyclerView.Adapter<AdapterNestedScrollView.NestedViewHolder> {
    private IBase inter;
    private List<ItemBase> list;

    public AdapterNestedScrollView(IBase inter, ArrayList<ItemBase> list) {
        this.inter = inter;
        this.list = list;
    }

    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_line,parent,false);
        return new NestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedViewHolder holder, int position) {
        final ItemBase data=inter.getData(position);
        holder.number.setText(data.getNumber());
    }

    @Override
    public int getItemCount() {
        return inter.getCountItem();
    }

    static class NestedViewHolder extends RecyclerView.ViewHolder{
        private TextView number;

        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.tv_number);
        }
    }
}
