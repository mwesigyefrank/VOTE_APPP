package com.example.amustvote;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listviewconts extends AppCompatActivity {
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    SqlTest test;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.listviewconts);
        listView=findViewById ( R.id.listView );
        arrayList=new ArrayList (  );
        test=new SqlTest ( this );

        Cursor data=test.getData ();
        while (data.moveToNext ()){
            arrayList.add ( data.getString ( 1 )+"\n"+data.getString ( 2 )+"\n"+data.getString ( 3 )  +"\n"+data.getString ( 4 ) );

        }

        arrayAdapter=new ArrayAdapter ( getApplicationContext (),android.R.layout.simple_list_item_1,arrayList );
        listView.setAdapter ( arrayAdapter );


    }
}

