package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleRecyclerViewActivity extends AppCompatActivity {
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;
    RecyclerView simpleRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);
        simpleRecyclerView = (RecyclerView) findViewById(R.id.simpleRecyclerView);
        simpleRecyclerViewItemArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            simpleRecyclerViewItemArrayList.add(new SimpleRecyclerViewItem("Item " + i));
        }
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter = new SimpleRecyclerViewAdapter(simpleRecyclerViewItemArrayList);
        simpleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        simpleRecyclerView.setAdapter(simpleRecyclerViewAdapter);
        simpleRecyclerView.setNestedScrollingEnabled(true);
    }
}
