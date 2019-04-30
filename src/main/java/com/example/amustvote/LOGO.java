package com.example.amustvote;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LOGO extends AppCompatActivity  {
  private Button sign;
  DatabaseReference databaseReference;
  EditText fullname,Email,ID,mobile,program,password;
  ProgressBar progressBar;
  private FirebaseAuth authuser;
  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_logo );
        //instantiating and typecasting data types of components
        fullname = (EditText) findViewById ( R.id.fname );
        Email = (EditText) findViewById ( R.id.email );
        ID = (EditText) findViewById ( R.id.std_id );
        program = (EditText) findViewById ( R.id.prog );
        getSupportActionBar ().hide ();
        password = (EditText) findViewById ( R.id.password );
        mobile=(EditText)findViewById (R.id.phone );
        sign=findViewById ( R.id.btnregister );
        authuser=FirebaseAuth.getInstance ();
        progressDialog=new ProgressDialog ( this );
        progressDialog.setTitle ( "login user" );
        databaseReference =FirebaseDatabase.getInstance ().getReference ().child ( "Users" );
        progressDialog.setCancelable ( false );
        progressDialog.setMessage ( "checking user information" );
        sign.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                progressDialog.show ();
                final String name=fullname.getText().toString ().trim ();
                final String email =Email.getText ().toString ().trim ();
                final String mpass=password.getText ().toString ().trim ();
                final String phone=mobile.getText ().toString ().trim ();
                final String id=ID.getText().toString ().trim ();
                final String prog =program.getText ().toString ().trim ();

                if (TextUtils.isEmpty ( name ) || TextUtils.isEmpty ( mpass ) || TextUtils.isEmpty ( email )) {
                    Toast.makeText ( getApplicationContext () , "Some Filed are empty" , Toast.LENGTH_SHORT ).show ();
                } else {

                    progressDialog.show ();
                    authuser.createUserWithEmailAndPassword ( email , mpass ).addOnCompleteListener ( new OnCompleteListener<AuthResult> () {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful ()) {
                                String x = authuser.getCurrentUser ().getUid ();
                                DatabaseReference current_user = databaseReference.child ( x);
                                current_user.child ( "Name" ).setValue ( name );
                                current_user.child ( "Email" ).setValue ( email );
                                current_user.child ( "Phone" ).setValue ( phone );
                                current_user.child ( "password" ).setValue ( mpass );
                                current_user.child ( "ID" ).setValue ( id );
                                current_user.child ( "program" ).setValue ( prog );
                                Toast.makeText (LOGO.this,"registered successfully",Toast.LENGTH_SHORT).show ();
progressDialog.dismiss ();
                            }
                        }
                    } ).addOnFailureListener ( new OnFailureListener () {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText ( getApplicationContext () , "Erro: " + e.getMessage () , Toast.LENGTH_SHORT ).show ();
                            progressDialog.dismiss ();
                        }
                    } );

                }
            }

        } );

    }




}
