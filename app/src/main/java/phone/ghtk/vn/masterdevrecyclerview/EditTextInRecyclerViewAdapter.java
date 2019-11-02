package phone.ghtk.vn.masterdevrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class EditTextInRecyclerViewAdapter extends RecyclerView.Adapter<EditTextInRecyclerViewAdapter.MyViewHolder> {
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;

    public EditTextInRecyclerViewAdapter(ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList) {
        this.simpleRecyclerViewItemArrayList = simpleRecyclerViewItemArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.edit_text_item, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final SimpleRecyclerViewItem simpleRecyclerViewItem = simpleRecyclerViewItemArrayList.get(i);
        myViewHolder.etItem.setText(simpleRecyclerViewItem.getmName());
    }

    @Override
    public int getItemCount() {
        return simpleRecyclerViewItemArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int position;
        EditText etItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            etItem = itemView.findViewById(R.id.etItem);

        }
    }
}
