package phone.ghtk.vn.masterdevrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.rcviewapp.R;
import phone.ghtk.vn.masterdevrecyclerview.adapter.Adapter;
import phone.ghtk.vn.masterdevrecyclerview.data.Items;

import java.util.ArrayList;

public class SimpleRCViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Items> item;
    LinearLayoutManager layoutManager;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rc_view);
        recyclerView = findViewById(R.id.rcView);
        item = new ArrayList<>();
        for (int i =0; i<1000;i++){
            item.add(new Items("Item "+i));
        }

        adapter = new Adapter(getApplicationContext(),item);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
