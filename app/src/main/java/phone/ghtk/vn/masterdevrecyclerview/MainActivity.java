package phone.ghtk.vn.masterdevrecyclerview;

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
    mArrayList.add("Recycler 1");
    mArrayList.add("Recycler 2");
    mArrayList.add("Recycler 3");
    mArrayList.add("Recycler 4");
    mArrayList.add("Recycler 5");
    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mArrayList);
    stringArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    mSpnView.setAdapter(stringArrayAdapter);
    mSpnView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Sellect " + mArrayList.get(position), Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }
}
