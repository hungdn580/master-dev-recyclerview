package phone.ghtk.vn.masterdevrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        spinner = findViewById (R.id.spn_mode);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource (this, R.array.arr_list_mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter (adapter);
        spinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected (AdapterView <?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent (MainActivity.this, RecyclerView1000Activity.class);
                        startActivity (intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent (MainActivity.this, RecyclerViewinScrollViewActivity.class);
                        startActivity (intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent (MainActivity.this, RecyclerViewinRecyclerViewActivity.class);
                        startActivity (intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent (MainActivity.this, EditTextinRecyclerViewActivity.class);
                        startActivity (intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent (MainActivity.this, RecyclerViewDragSwipeActivity.class);
                        startActivity (intent4);
                        break;
                    default:
                        Toast.makeText (MainActivity.this, "Vui lòng chọn 1 trường hợp", Toast.LENGTH_SHORT).show ();
                        break;


                }
            }

            @Override
            public void onNothingSelected (AdapterView <?> parent) {
                Toast.makeText (MainActivity.this, "Vui lòng chọn 1 trường hợp", Toast.LENGTH_SHORT).show ();

            }
        });


    }

    private void onModeClick ( ) {
    }
}
