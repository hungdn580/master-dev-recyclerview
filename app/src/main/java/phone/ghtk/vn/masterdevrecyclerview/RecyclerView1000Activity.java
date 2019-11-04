package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import phone.ghtk.vn.masterdevrecyclerview.Adapter.RecyclerView1000Adapter;

public class RecyclerView1000Activity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView1000Adapter mRcvAdapter;
    ArrayList <String> data;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recycler_view1000);
        mRecyclerView =  findViewById(R.id.rv1000);
        data = new ArrayList <> ();
        for(int i = 1; i<=1000;i++){
            data.add ("Number: "+i);
        }
        mRcvAdapter = new RecyclerView1000Adapter(this, data);

        LinearLayoutManager layoutManager = new LinearLayoutManager (getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRcvAdapter);
    }
}
