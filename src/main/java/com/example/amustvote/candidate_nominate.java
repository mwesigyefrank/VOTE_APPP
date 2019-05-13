package com.example.amustvote;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class candidate_nominate extends AppCompatActivity {
    EditText name,position,fee,course;
    SqlTest sqlTest;


    Button save,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_candidate_nominate );
        sqlTest=new SqlTest ( this );




        name=(EditText) findViewById ( R.id.edtname );
        position=(EditText)findViewById ( R.id.position );
        fee=(EditText)findViewById ( R.id.fee );
        course=(EditText)findViewById ( R.id.course );
        save=findViewById ( R.id.sv );
        view=findViewById ( R.id.vv );
        getSupportActionBar ().hide ();
        view.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent inte= new Intent ( candidate_nominate.this,listviewconts.class );
                startActivity ( inte );
            }
        } );



        save.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                int x= Integer.parseInt ( fee.getText ().toString () );

                boolean getDate=sqlTest.saveDate ( name.getText ().toString ().trim (),position.getText ().toString ().toString (),Integer.parseInt ( fee.getText ().toString () ),course.getText ().toString ().trim () );
                if(getDate==true){
                    Toast.makeText ( candidate_nominate.this , "Data inserted succesfully in the database" , Toast.LENGTH_SHORT ).show ();

                }
                else{
                    Toast.makeText ( candidate_nominate.this , "Sorry an error occurred" , Toast.LENGTH_SHORT ).show ();
                }

            }

        } );


    }

}




