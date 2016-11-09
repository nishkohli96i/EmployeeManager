package com.appyblues.nishant.employeemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.appyblues.nishant.emplogin";
    String message ="hi";
Button b1,b2,b3,b4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(this);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    public void onClick(View view) {
        if(view==b2)
        {
            Intent iu=new Intent(MainActivity.this,emplogin.class);
            startActivity(iu);

        }
        if(view==b1)
        {
            Intent iu=new Intent(MainActivity.this,About.class);
            startActivity(iu);

        }
        if(view==b3)
        {
            Intent iu=new Intent(MainActivity.this,hrlogin.class);
            startActivity(iu);

        }
        if(view==b4)
        {
           Intent iu=new Intent(MainActivity.this,projects.class);
            startActivity(iu);

        }

    }

}
