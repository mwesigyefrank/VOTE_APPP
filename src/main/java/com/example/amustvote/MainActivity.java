package com.example.amustvote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText uname;
    private EditText pass;
    private Button lod;
    private Button submit;
//MWESIGYE FRANK
    //2017/BIT/164
    //COURSE WORK



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText4);
        lod=findViewById(R.id.button);
        lod.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              MainActivity.this.load(uname.getText().toString(),pass.getText().toString());

            }
        });

        submit=findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intek= new Intent(MainActivity.this,LOGO.class);
                startActivity(intek);
            }
        });




    }



    public  void load(String uname,String pass){
         if (uname.equals("frank")&&pass.equals("1234567890")){
             Intent intent=new Intent(MainActivity.this,LOAD_PAGE.class);
             startActivity(intent);
         }
         else{
             Toast.makeText(MainActivity.this,"username and password dont mutch",Toast.LENGTH_SHORT).show();
         }


    }
    protected void OnResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,"app restarted",Toast.LENGTH_SHORT).show();
    }
    protected void OnStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,"app started",Toast.LENGTH_SHORT).show();

    }
    protected void onDestroy() {

        super.onDestroy();
        Toast.makeText(MainActivity.this,"app closed",Toast.LENGTH_SHORT).show();
    }

}
