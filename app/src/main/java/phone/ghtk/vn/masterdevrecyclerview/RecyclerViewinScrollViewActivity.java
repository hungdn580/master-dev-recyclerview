package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewinScrollViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewScrollApater recyclerViewScrollApater;
    ArrayList<String> mData;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recycler_viewin_scroll_view);
        recyclerView = findViewById (R.id.listRecyclerView);
        mData = new ArrayList <> ();
        for(int i=1;i<30;i++){
            mData.add ("Number: "+i);
        }
        recyclerViewScrollApater = new RecyclerViewScrollApater (this, mData);
        LinearLayoutManager layoutManager = new LinearLayoutManager (getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewScrollApater);
        recyclerView.setNestedScrollingEnabled (false);

    }
}
