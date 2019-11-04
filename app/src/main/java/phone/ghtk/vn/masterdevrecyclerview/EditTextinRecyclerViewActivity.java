package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import phone.ghtk.vn.masterdevrecyclerview.Adapter.EditTextRecyclerViewAdapter;

public class EditTextinRecyclerViewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    EditTextRecyclerViewAdapter mRcvAdapter;
    ArrayList <String> data;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_textin_recycler_view);
        mRecyclerView = findViewById (R.id.rvEditText);
        data = new ArrayList <> ();
        for (int i = 1; i < 30; i++) {
            data.add ("Number: " + i);
        }
        mRcvAdapter = new EditTextRecyclerViewAdapter (this, data);

        LinearLayoutManager layoutManager = new LinearLayoutManager (getApplicationContext ());
        layoutManager.setOrientation (LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager (layoutManager);
        mRecyclerView.setAdapter (mRcvAdapter);

    }

}
