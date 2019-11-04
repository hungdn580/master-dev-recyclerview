package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Adapter.Item;
import phone.ghtk.vn.masterdevrecyclerview.Adapter.ItemAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Adapter.SubItem;

public class RecyclerViewinRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recycler_viewin_recycler_view);
        RecyclerView rvItem = findViewById(R.id.rv_item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewinRecyclerViewActivity.this);
        ItemAdapter itemAdapter = new ItemAdapter(buildItemList());
        rvItem.setAdapter(itemAdapter);
        rvItem.setLayoutManager(layoutManager);
    }

    private List<Item> buildItemList() {
        List <Item> itemList = new ArrayList <> ();
        for (int i=0; i<10; i++) {
            Item item = new Item("Item "+i, buildSubItemList());
            itemList.add(item);
        }
        return itemList;
    }

    private List<SubItem> buildSubItemList() {
        List<SubItem> subItemList = new ArrayList<>();
        for (int i=0; i<3; i++) {
            SubItem subItem = new SubItem("Sub Item "+i, "Description "+i);
            subItemList.add(subItem);
        }
        return subItemList;
    }

}
