package phone.ghtk.vn.masterdevrecyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import phone.ghtk.vn.masterdevrecyclerview.adapter.AdapterDragAndSwipe;
import phone.ghtk.vn.masterdevrecyclerview.adapter.AdapterEditText;
import phone.ghtk.vn.masterdevrecyclerview.adapter.AdapterFragmentBase;
import phone.ghtk.vn.masterdevrecyclerview.adapter.AdapterNestedScrollView;
import phone.ghtk.vn.masterdevrecyclerview.adapter.AdapterRecyclerView;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IBase;
import phone.ghtk.vn.masterdevrecyclerview.inter_.IRecycler;
import phone.ghtk.vn.masterdevrecyclerview.inter_.ItemTouchHelperAdapter;
import phone.ghtk.vn.masterdevrecyclerview.model.ItemBase;

public class MainActivity extends AppCompatActivity implements IBase, IRecycler {
    private Spinner spinner;
    private List<ItemBase> itemBases;
    private RecyclerView recyclerView;
    private AdapterFragmentBase adapterBase;
    private AdapterNestedScrollView adapterScroll;
    private AdapterRecyclerView adapterRecyclerView;
    private AdapterDragAndSwipe adapterDragAndSwipe;
    private AdapterEditText adapterEditText;
    private ItemBase itemBase;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        final ArrayList<String> category = new ArrayList<>();
        category.add("RecyclerView base");
        category.add("RecyclerView in ScrollView or NestedScrollView");
        category.add("RecyclerView in RecyclerView");
        category.add("RecyclerView holder Edittext");
        category.add("RecyclerView implement Drag and Swipe");

        itemBases=getDataItem();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, category);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        recyclerView = findViewById(R.id.rc_base);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterBase = new AdapterFragmentBase(MainActivity.this, getDataItem());
                        recyclerView.setAdapter(adapterBase);
                        Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        recyclerView = findViewById(R.id.rc_base);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterScroll = new AdapterNestedScrollView(MainActivity.this, getDataItem());
                        recyclerView.setAdapter(adapterScroll);
                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        recyclerView = findViewById(R.id.rc_base);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterRecyclerView = new AdapterRecyclerView(MainActivity.this, getDataItem());
                        recyclerView.setAdapter(adapterRecyclerView);
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        recyclerView = findViewById(R.id.rc_base);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterEditText = new AdapterEditText(MainActivity.this,getDataEdit());
                        recyclerView.setAdapter(adapterEditText);
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        recyclerView = findViewById(R.id.rc_base);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                        adapterDragAndSwipe = new AdapterDragAndSwipe( MainActivity.this, getDataItem());
                        recyclerView.setAdapter(adapterDragAndSwipe);
                        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(new ItemTouchHelperAdapter() {

                            @Override
                            public void onItemMove(int fromPosition, int toPosition) {
                                adapterDragAndSwipe.onItemMove(fromPosition,toPosition);
                            }

                            @Override
                            public void onItemDismiss(int position) {
                                adapterDragAndSwipe.onItemDismiss(position);
                            }

                        });
                        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                        itemTouchHelper.attachToRecyclerView(recyclerView);
                        Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<ItemBase> getDataItem() {
        ArrayList<ItemBase> itemBases = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            itemBase = new ItemBase(i + "");
            itemBases.add(i, itemBase);
        }
        return itemBases;
    }

    private List<ItemBase> getDataEdit() {
        itemBases = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            itemBase = new ItemBase( "");
            itemBases.add(i, itemBase);
        }
        return itemBases;
    }

    @Override
    public int getCountItem() {
        return itemBases.size();
    }

    @Override
    public ItemBase getData(int position) {
        return itemBases.get(position);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View view,int position) {
//        recyclerView = findViewById(R.id.rc_base);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
//        adapterBase = new AdapterFragmentBase(MainActivity.this, new ArrayList<ItemBase>());
//        recyclerView.setAdapter(adapterBase);
//        Toast.makeText(MainActivity.this, "item con", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
