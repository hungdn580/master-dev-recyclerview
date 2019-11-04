package com.example.rcviewapp.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcviewapp.data.Items;
import com.example.rcviewapp.R;

import java.util.ArrayList;

public class EditTextRCViewAdapter extends RecyclerView.Adapter<EditTextRCViewAdapter.ViewHoler> {
    private Context context;
    private ArrayList<Items> items;

    public EditTextRCViewAdapter(Context context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.edit_text_items, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
         Items i = items.get(position);
         holder.editText.setText(i.getName());
         holder.editText.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        EditText editText;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            editText = (EditText)itemView.findViewById(R.id.editTextItem);

        }
    }
}
