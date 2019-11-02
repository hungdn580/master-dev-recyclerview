package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EditTextInActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_in_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.rvEdt);
        simpleRecyclerViewItemArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            simpleRecyclerViewItemArrayList.add(new SimpleRecyclerViewItem(""));
        }
        EditTextInRecyclerViewAdapter editTextInRecyclerViewAdapter = new EditTextInRecyclerViewAdapter(simpleRecyclerViewItemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(editTextInRecyclerViewAdapter);
        recyclerView.setItemViewCacheSize(simpleRecyclerViewItemArrayList.size());

    }
}
