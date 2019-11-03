package com.example.rcviewappp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NextedScrollViewActivity extends AppCompatActivity {
    private RecyclerView list;
    private RcViewApdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_rc_in_scroll_view );

        list = (RecyclerView) findViewById ( R.id.ScrollViewRc );

        //Data
        ArrayList<String> country = new ArrayList<> ();
        country.add ( "Nigeria" );
        country.add ( "China" );
        country.add ( "USA" );
        country.add ( "Ghana" );
        country.add ( "Canada" );
        country.add ( "Finland" );
        country.add ( "Denmark" );
        country.add ( "Argentina" );
        country.add ( "Andorra" );
        country.add ( "Angola" );
        country.add ( "Benin" );
        country.add ( "Brazil" );
        country.add ( "Chile" );
        country.add ( "Denmark" );
        country.add ( "Egypt" );
        country.add ( "Fiji" );
        country.add ( "France" );
        country.add ( "Togo" );

        LinearLayoutManager layoutManager = new LinearLayoutManager ( this );
        list.setLayoutManager ( layoutManager );
        recyclerAdapter = new RcViewApdapter ( this, country );
        list.addItemDecoration ( new DividerItemDecoration ( list.getContext (), layoutManager.getOrientation () ) );
        list.setAdapter ( recyclerAdapter );
        ViewCompat.setNestedScrollingEnabled ( list, false );
    }
}