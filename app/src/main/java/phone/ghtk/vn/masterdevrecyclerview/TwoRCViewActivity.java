package phone.ghtk.vn.masterdevrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rcviewapp.R;
import phone.ghtk.vn.masterdevrecyclerview.adapter.BigAdapter;
import phone.ghtk.vn.masterdevrecyclerview.data.BigItems;

import java.util.ArrayList;

public class TwoRCViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    BigAdapter bigAdapter;
    ArrayList<BigItems> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_rc_view);
        recyclerView = findViewById(R.id.twoRCView);
          items = new ArrayList<>();
          for (int i=1;i<10;i++){
              items.add(new BigItems("RC "+i));
          }
          bigAdapter = new BigAdapter(this,items);
        layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bigAdapter);
    }
}
