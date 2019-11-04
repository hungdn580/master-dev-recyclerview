package phone.ghtk.vn.masterdevrecyclerview.holder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import phone.ghtk.vn.masterdevrecyclerview.R;
import phone.ghtk.vn.masterdevrecyclerview.item2;

public class ArtistViewHolder extends ChildViewHolder {
    private TextView mTextView;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_item2);
    }

    public void onBind(item2 it){
          mTextView.setText(it.name);
    }
}
