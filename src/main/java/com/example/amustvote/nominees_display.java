package com.example.amustvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class nominees_display extends AppCompatActivity {
    int[] images;
   Adapter adpter;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_nominees_display);
        final ListView reg = findViewById(R.id.how);
        final ArrayList<String> list = new ArrayList<String>();

        final String [] positions={
                "PRESIDENT","REPORTER","SPEAKER","GUILD REPRESENTATIVE","SPORTS MAN"
        };



      images =new int[]{R.drawable.voted,R.drawable.guld,R.drawable.images,R.drawable.nominate,R.drawable.success};
        adpter = new Adapter (this,images,positions);
        reg.setAdapter(adpter);

        reg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(positions[position]=="PRESIDENT"){
//                    Toast.makeText ( nominees_display.this , ""+positions[position] , Toast.LENGTH_SHORT ).show ();

                }
                else if(positions[position]=="REPORTER"){



                }
                else if(positions[position]=="SPEAKER"){


                }
                else if(positions[position]=="GUILD REPRESENTATIVE"){


                }
                else{


                }






            }
        });
    }
}
