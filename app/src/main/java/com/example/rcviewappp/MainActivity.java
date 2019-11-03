package com.example.rcviewappp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner mspinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mspinner = findViewById ( R.id.spnRview );
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add ( "chọn 0 " );
        arrayList.add ( "Simple Recyle View" );
        arrayList.add ( "Nexted Scroll View " );
        arrayList.add ( "Two RCView Activity" );
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        stringArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinner.setAdapter(stringArrayAdapter);
        mspinner.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        Intent intent = new Intent (MainActivity.this, SimpleRCViewActivity.class);
                        startActivity(intent);
                        break;
//                    case 2:
//                        Intent i = new Intent (getBaseContext (), NextedScrollViewActivity.class);
//                        startActivity(i);
//                        break;
                    case 3:
                        Intent intent1 = new Intent ( getBaseContext (),TwoRCVỉewActivity.class );
                        startActivity ( intent1 );
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
    }
}
