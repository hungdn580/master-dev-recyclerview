package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Model.EditModel;
import phone.ghtk.vn.masterdevrecyclerview.R;

public class EditTextAdapter extends RecyclerView.Adapter<EditTextAdapter.ViewHolder> {

    private List<EditModel> mList;

    public EditTextAdapter(List<EditModel> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_edittext, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.edtName.setText(mList.get(i).getValue() + "");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText edtName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.edtName = itemView.findViewById(R.id.edtItemText);
            edtName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mList.get(getAdapterPosition()).setValue(edtName.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
