package com.example.amustvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4;
    Button btn1,btn3,btn4,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        txt1=findViewById ( R.id.eliya );
        txt2=(TextView)findViewById ( R.id.pol );
        txt3=(TextView)findViewById ( R.id.vmk );
        txt4=(TextView)findViewById ( R.id.umaru );
        btn1=findViewById ( R.id.umar );
        btn2=findViewById ( R.id.kats );
        btn3=findViewById ( R.id.eli );
        btn4=findViewById ( R.id.pal );

    }

    public void onNdahuraClicked(View view) {
        String countn=txt2.getText ().toString ().trim ();
        int count=Integer.parseInt ( countn );
        count++;
        txt1.setText ( String.valueOf (count));
    }

    public void UmaruClicked(View view) {
        String UmaruCount=txt4.getText ().toString ().trim ();
        int countu=Integer.parseInt ( UmaruCount );
        countu++;
        txt4.setText ( String.valueOf (countu));
    }

    public void onEliyaClicked(View view) {
        String counteli=txt1.getText ().toString ().trim ();
        int counting=Integer.parseInt ( counteli );
        counting++;
        txt1.setText ( String.valueOf (counting));
    }

    public void onkatsClicked(View view) {
        String katongole=txt3.getText ().toString ().trim ();
        int countkat=Integer.parseInt ( katongole );
        countkat++;
        txt3.setText ( String.valueOf (countkat));
    }
}
