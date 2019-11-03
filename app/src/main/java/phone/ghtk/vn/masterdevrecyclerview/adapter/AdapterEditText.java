package phone.ghtk.vn.masterdevrecyclerview.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IBase;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public class AdapterEditText extends RecyclerView.Adapter<AdapterEditText.EditViewHolder> {
    private IBase inter;
    private List<ItemBase> list;

    public AdapterEditText(IBase inter, List<ItemBase> list) {
        this.inter = inter;
        this.list = list;
    }

    @NonNull
    @Override
    public EditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_edittext,parent,false);
        return new EditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EditViewHolder holder, int position) {
        final ItemBase data=inter.getData(position);
        holder.editText.setText(data.getNumber()+"");

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inter.getData(holder.getAdapterPosition()).setNumber(holder.editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return inter.getCountItem();
    }

    static class EditViewHolder extends RecyclerView.ViewHolder{
        private EditText editText;

        public EditViewHolder(@NonNull View itemView) {
            super(itemView);
            editText=itemView.findViewById(R.id.edit_text);
        }
    }
}
