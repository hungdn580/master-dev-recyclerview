package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  Spinner mSpnView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mSpnView = (Spinner) findViewById(R.id.spnView);
    final ArrayList<String> mArrayList = new ArrayList<>();
    mArrayList.add("Chọn RecyclerView");
    mArrayList.add("SimpleRecyclerView");
    mArrayList.add("RecyclerView In ScrollView");
    mArrayList.add("EditText In RecyclerView");
    mArrayList.add("Drag and Swipe");
    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mArrayList);
    stringArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    mSpnView.setAdapter(stringArrayAdapter);
    mSpnView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          switch (position) {
              case 1 :
                  Intent intent = new Intent(MainActivity.this, SimpleRecyclerViewActivity.class);
                  startActivity(intent);
                  break;
              case 2 :
                  Intent intent1 = new Intent(MainActivity.this, RecyclerViewInScrollViewActivity.class);
                  startActivity(intent1);
                  break;
              case 3 :
                  Intent intent2 = new Intent(MainActivity.this, EditTextInActivity.class);
                  startActivity(intent2);
                  break;
              case 4 :
                  Intent intent3 = new Intent(MainActivity.this, DragSwipeActivity.class);
                  startActivity(intent3);
                  break;
          }
      }
      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }

}
