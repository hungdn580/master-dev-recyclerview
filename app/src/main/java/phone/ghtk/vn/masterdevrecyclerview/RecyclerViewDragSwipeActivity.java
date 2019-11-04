package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import phone.ghtk.vn.masterdevrecyclerview.Adapter.RecyclerViewDragSwipeAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Interface.ItemTouchListenner;

public class RecyclerViewDragSwipeActivity extends AppCompatActivity {
    private RecyclerViewDragSwipeAdapter mRevDragSwipeAdapter;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recycler_view_drag_swipe);
        widgetRecyclerView();
    }

    private void widgetRecyclerView ( ) {
        RecyclerView recyclerView =findViewById (R.id.rvDragSwipe);
        mRevDragSwipeAdapter = new RecyclerViewDragSwipeAdapter ();
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        recyclerView.setAdapter (mRevDragSwipeAdapter);
        mRevDragSwipeAdapter.addData (getData ());
        addItemTouchCallback (recyclerView);
    }
    private void addItemTouchCallback (RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback (new ItemTouchListenner () {
            @Override
            public void onMove (int oldPosition, int newPosition) {
                mRevDragSwipeAdapter.onMove (oldPosition, newPosition);
            }

            @Override
            public void swipe (int position, int direction) {
                mRevDragSwipeAdapter.swipe (position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper (callback);
        itemTouchHelper.attachToRecyclerView (recyclerView);
    }
    private List getData ( ) {
        List <String> data = new ArrayList <> ();
        for (int i = 0; i < 100; i++) {
            data.add ("Number: " + i);
        }
        return data;
    }
}
