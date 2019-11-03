package phone.ghtk.vn.masterdevrecyclerview.inter_;

import android.view.View;

import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public interface IRecycler {
    int getCountItem();
    ItemBase getData(int position);
    void onClick(View view, int position);
}
