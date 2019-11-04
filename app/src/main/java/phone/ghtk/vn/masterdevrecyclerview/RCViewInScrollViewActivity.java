package phone.ghtk.vn.masterdevrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.example.rcviewapp.R;
import phone.ghtk.vn.masterdevrecyclerview.adapter.Adapter;
import phone.ghtk.vn.masterdevrecyclerview.data.Items;

import java.util.ArrayList;

public class RCViewInScrollViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Items> items;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc_view_in_scroll_view);
        recyclerView = findViewById(R.id.rcViewInScrollView);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
       items = new ArrayList<>();
        for (int i =0; i<1000;i++){
            items.add(new Items("Item "+i));
        }

        adapter = new Adapter(getApplicationContext(),items);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
    }
}
