package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import phone.ghtk.vn.masterdevrecyclerview.data.Items;
import com.example.rcviewapp.R;

import java.util.ArrayList;

public class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Items> items;

    public SmallAdapter(Context context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_small_rc_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Items i = items.get(position);
        holder.textView.setText(i.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtSmallRCView);
        }
    }
}
