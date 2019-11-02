package phone.ghtk.vn.masterdevrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import phone.ghtk.vn.masterdevrecyclerview.Adapter.DragAndSwipeAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Adapter.EditTextAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Adapter.NumberListAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Adapter.RecyclerViewInsideRecyclerViewAdapter;
import phone.ghtk.vn.masterdevrecyclerview.Interface.ItemTouchListenner;
import phone.ghtk.vn.masterdevrecyclerview.Model.BaseItem;
import phone.ghtk.vn.masterdevrecyclerview.Model.EditModel;

public class MainActivity extends AppCompatActivity {

    Spinner sprChoose;
    RecyclerView rcvDemo;
    NumberListAdapter numberListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sprChoose = findViewById(R.id.sprChoose);
        rcvDemo = findViewById(R.id.rcvDemo);

        ArrayList<String> arrChoose = new ArrayList<>();
        arrChoose.add("Recyclerview ");
        arrChoose.add("Recyclerview trong ScrollView ");
        arrChoose.add("RecyclerView trong RecyclerView ");
        arrChoose.add("RecyclerView chứa Edittext ");
        arrChoose.add("RecyclerView implement Drag and Swipe ");

        final ArrayList<Integer> arrNumber = new ArrayList<>();
        for (int i = 1; i <= 1000; i++)
            arrNumber.add(i);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, arrChoose);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sprChoose.setAdapter(adapter);
        sprChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = sprChoose.getPositionForView(view);
                switch (index) {
                    case 0: {
                        numberListAdapter = new NumberListAdapter(arrNumber);
                        rcvDemo.setAdapter(numberListAdapter);
                        rcvDemo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                    }
                    case 1: {
                        numberListAdapter = new NumberListAdapter(arrNumber);
                        //rcvDemo.setNestedScrollingEnabled(false);
                        rcvDemo.setAdapter(numberListAdapter);
                        rcvDemo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                    }
                    case 2: {
                        ArrayList<Integer> arrSub = new ArrayList<>();
                        for (int i = 1; i <= 10; i++)
                            arrSub.add(i);

                        ArrayList<BaseItem> arrBase = new ArrayList<>();
                        for (int i = 1; i <= 1000; i++)
                            arrBase.add(new BaseItem("Item " + i, arrSub));
                        RecyclerViewInsideRecyclerViewAdapter viewInsideRecyclerViewAdapter = new RecyclerViewInsideRecyclerViewAdapter(arrBase);
                        rcvDemo.setAdapter(viewInsideRecyclerViewAdapter);
                        rcvDemo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                    }
                    case 3: {
                        ArrayList<EditModel> arrEdittext = new ArrayList<>();
                        for (int i = 1; i <= 1000; i++)
                            arrEdittext.add(new EditModel(""));
                        EditTextAdapter editTextAdapter = new EditTextAdapter(arrEdittext);
                        rcvDemo.setAdapter(editTextAdapter);
                        rcvDemo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                    }
                    case 4: {
                        final DragAndSwipeAdapter dragAndSwipeAdapter = new DragAndSwipeAdapter(arrNumber);
                        rcvDemo.setAdapter(dragAndSwipeAdapter);
                        rcvDemo.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        ItemTouchHelper.Callback callback = new DemoItemTouchHelperCallback(new ItemTouchListenner() {
                            @Override
                            public void onItemMove(int x, int y) {
                                dragAndSwipeAdapter.onItemMove(x, y);
                            }

                            @Override
                            public void onItemSwipe(int x) {
                                dragAndSwipeAdapter.onItemSwipe(x);
                            }
                        });
                        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                        itemTouchHelper.attachToRecyclerView(rcvDemo);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
