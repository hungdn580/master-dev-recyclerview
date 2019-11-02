package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class RecyclerViewInScrollViewActivity extends AppCompatActivity {
    ScrollView mScrollView;
    RecyclerView mRecyclerView;
    ArrayList<SimpleRecyclerViewItem> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_in_scroll_view);
        mScrollView = (ScrollView) findViewById(R.id.sv);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvInScrollView);
        mArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            mArrayList.add(new SimpleRecyclerViewItem("Item " + i));
        }
        RecyclerViewInScrollViewAdapter recyclerViewInScrollViewAdapter = new RecyclerViewInScrollViewAdapter(mArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(recyclerViewInScrollViewAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
    }
}
