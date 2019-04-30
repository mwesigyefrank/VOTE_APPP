package com.example.amustvote;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText uemail;
    private EditText pass;
    private Button lod;
    private Button submit;
    private ProgressDialog progressDialog;
    FirebaseAuth authuser;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uemail=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.editText4);
        getSupportActionBar().hide();
        lod=findViewById(R.id.login);
        authuser=FirebaseAuth.getInstance ();

         progressDialog=new ProgressDialog ( this );
         progressDialog.setTitle ( "login user" );
         progressDialog.setCancelable ( false );
         progressDialog.setMessage ( "checking user information" );
lod.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick(View v) {
        progressDialog.show ();
        authuser.signInWithEmailAndPassword (uemail.getText ().toString (),pass.getText ().toString ()).addOnCompleteListener ( new OnCompleteListener<AuthResult> () {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful ()){

                    Intent loadme=new Intent (MainActivity.this,LOAD_PAGE.class);
                    startActivity ( loadme );
                    progressDialog.dismiss ();
                }
                else{

                    Toast.makeText (MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show ();
                    progressDialog.dismiss ();
                }
            }
        } );

    }
} );




        submit=findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intek= new Intent(MainActivity.this,LOGO.class);
                startActivity(intek);
            }
        });




    }





}
