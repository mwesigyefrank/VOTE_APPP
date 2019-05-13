package com.example.amustvote;

import android.content.Intent;
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
                    Intent president =new Intent ( nominees_display.this,candidate_nominate.class );
                    startActivity ( president );

                }
                else if(positions[position]=="REPORTER"){

                    Intent report =new Intent ( nominees_display.this,candidate_nominate.class );
                    startActivity ( report );

                }
                else if(positions[position]=="SPEAKER"){

                    Intent speaker =new Intent ( nominees_display.this,candidate_nominate.class );
                    startActivity ( speaker );
                }
                else if(positions[position]=="GUILD REPRESENTATIVE"){

                    Intent president =new Intent ( nominees_display.this,candidate_nominate.class );
                    startActivity ( president );
                }
                else{


                }






            }
        });
    }
}
