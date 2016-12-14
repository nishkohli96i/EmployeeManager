package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class editempht extends Activity implements View.OnClickListener{

    EditText e1,e2,e3,e4;
    Button b1,b3;
    TextView t1,t2,t3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editemphr);
        e1=(EditText)findViewById(R.id.editText11);
        e2=(EditText)findViewById(R.id.editText12);
        e3=(EditText)findViewById(R.id.editText13);
        e4=(EditText)findViewById(R.id.editText14);
        b1=(Button)findViewById(R.id.button10);
        b1.setOnClickListener(this);

        b3=(Button)findViewById(R.id.button16);
        b3.setOnClickListener(this);
        t1=(TextView)findViewById(R.id.textView18);
        t1.setVisibility(View.INVISIBLE);
        t2=(TextView)findViewById(R.id.textView19);
        t2.setVisibility(View.INVISIBLE);
        t3=(TextView)findViewById(R.id.textView20);
        t3.setVisibility(View.INVISIBLE);
        e2.setVisibility(View.INVISIBLE);
        e3.setVisibility(View.INVISIBLE);
        e4.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onClick(View view) {
    if(view==b1)
    {
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        e2.setVisibility(View.VISIBLE);
        e3.setVisibility(View.VISIBLE);
        e4.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
    }

        if(view==b3)
        {
         finish();
        }

    }
}
