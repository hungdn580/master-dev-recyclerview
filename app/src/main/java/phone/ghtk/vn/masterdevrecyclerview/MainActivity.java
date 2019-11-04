package phone.ghtk.vn.masterdevrecyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.rcviewapp.R;

import java.util.ArrayList;

import phone.ghtk.vn.masterdevrecyclerview.EditTextInRCViewActivity;
import phone.ghtk.vn.masterdevrecyclerview.RCViewInScrollViewActivity;
import phone.ghtk.vn.masterdevrecyclerview.SimpleRCViewActivity;
import phone.ghtk.vn.masterdevrecyclerview.TwoRCViewActivity;

public class MainActivity extends AppCompatActivity {
  ArrayList<String> arrayList;
  Spinner spinner;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    spinner = findViewById(R.id.mspinner);
    arrayList = new ArrayList<>();
    arrayList.add("Chọn 0");
    arrayList.add("Simple RCView");
    arrayList.add("TwoRCViewActivity");
    arrayList.add("RCViewInScrollViewActivity");
    arrayList.add("EditTextInRCViewActivity");
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), R.layout.support_simple_spinner_dropdown_item,arrayList);
    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
          case 1:
            Intent intent1 = new Intent(getBaseContext(), SimpleRCViewActivity.class);
            startActivity(intent1);
            break;
          case 2:
            Intent intent2 = new Intent(getBaseContext(), TwoRCViewActivity.class);
            startActivity(intent2);
            break;
          case 3:
            Intent intent3 = new Intent(getBaseContext(), RCViewInScrollViewActivity.class);
            startActivity(intent3);
            break;
          case 4:
            Intent intent4 = new Intent(getBaseContext(), EditTextInRCViewActivity.class);
            startActivity(intent4);
            break;
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }
}

