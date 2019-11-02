package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class DragSwipeActivity extends AppCompatActivity{
    ArrayList<SimpleRecyclerViewItem> simpleRecyclerViewItemArrayList;
    RecyclerView recyclerView;
    DragSwipeAdapter dragSwipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_swipe);
        recyclerView = (RecyclerView) findViewById(R.id.rvDragSwipe);
        simpleRecyclerViewItemArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            simpleRecyclerViewItemArrayList.add(new SimpleRecyclerViewItem("Item" + i));
        }
        dragSwipeAdapter = new DragSwipeAdapter(simpleRecyclerViewItemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dragSwipeAdapter);
        addItemCallBack(recyclerView);
    }
    public void addItemCallBack(RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new DragSwipeTouchHelper(new DragSwipeTouchHelper.AnimationListernner() {
            @Override
            public void onMove(int fromPosition, int toPosition) {
                dragSwipeAdapter.onMove(fromPosition, toPosition);
            }

            @Override
            public void onSwipe(int position, int direction) {
                dragSwipeAdapter.swipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
