package phone.ghtk.vn.masterdevrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.R;

public class EditTextRecyclerViewAdapter extends RecyclerView.Adapter <EditTextRecyclerViewAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List <String> data;

    public EditTextRecyclerViewAdapter (Context mContext, List <String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_edittext, parent, false);
        return new RecyclerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.editText.setText(data.get(position));
        holder.editText.addTextChangedListener (new TextWatcher () {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {
//                data.get (position) = s.toString ();
            }
            @Override
            public void afterTextChanged (Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        EditText editText;
        LinearLayout linear;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.edittext);
            linear = (LinearLayout) itemView.findViewById(R.id.linear);
        }


    }
}
