package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IRecycler;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.RecyclerviewViewHolder> {
    private IRecycler inter;
    private List<ItemBase> list;
    private List<ItemBase> itemBases=new ArrayList<>();


    public AdapterRecyclerView(IRecycler inter, ArrayList<ItemBase> list) {
        this.inter = inter;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_child,parent,false);
        return new RecyclerviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewViewHolder holder, int position) {
        final ItemBase data=inter.getData(position);
        holder.textView.setText(data.getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                data.setClick(true);


            }
        });
        if (data.isClick()==true){
            @SuppressLint("WrongConstant")
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
            linearLayoutManager.setInitialPrefetchItemCount(inter.getCountItem());
            AdapterRecyclerviewChild adapterRecyclerviewChild = new AdapterRecyclerviewChild(getData());
            holder.recyclerView.setAdapter(adapterRecyclerviewChild);
            holder.recyclerView.setLayoutManager(linearLayoutManager);
        }else {
            holder.recyclerView.removeAllViews();
        }


    }

    @Override
    public int getItemCount() {
        return inter.getCountItem();
    }

    private List<ItemBase> getData() {
        itemBases = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemBase itemBase = new ItemBase( "item"+i);
            itemBases.add(i, itemBase);
        }
        return itemBases;
    }

    static class RecyclerviewViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;

        public RecyclerviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_number);
            recyclerView=itemView.findViewById(R.id.rc_child);
        }
    }
}
