package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MultiLevelActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_level);
        recyclerView = (RecyclerView) findViewById(R.id.rvParent);
        simpleRecyclerViewItemArrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            simpleRecyclerViewItemArrayList.add(new SimpleRecyclerViewItem("Item" + i));
        }
        ParentMultiLevelAdapter parentMultiLevelAdapter = new ParentMultiLevelAdapter(simpleRecyclerViewItemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentMultiLevelAdapter);
    }
}
