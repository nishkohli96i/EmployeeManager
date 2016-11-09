package com.appyblues.nishant.employeemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class addproject extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    EditText t1,t2;
    AutoCompleteTextView tv;
    DBManager hg;
    String empnames;
    String [] names=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproject);
        b1=(Button)findViewById(R.id.button24);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button27);
        b2.setOnClickListener(this);
        t1=(EditText)findViewById(R.id.editText22);
        t2=(EditText)findViewById(R.id.editText23);
        tv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        hg=new DBManager(this);
        empnames=hg.empnameprint();
        names=empnames.split("\n");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,names);
        tv.setThreshold(1);
        tv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if(v ==b1)
        {
            if(t1.getText().toString().equals(" "))
            {
                Toast.makeText(this,"Enter The Project Name",Toast.LENGTH_SHORT).show();
            }
            else
            {
                try
                {
                    Toast.makeText(this," Project "+t1.getText().toString()+"  Added ",Toast.LENGTH_SHORT).show();
                    hg.addnewproj(t1.getText().toString(), t2.getText().toString(), tv.getText().toString());
                    t1.setText(""); t2.setText(""); tv.setText("");
                }
            catch (Exception ex)
            {
                Toast.makeText(this,ex.getMessage(),Toast.LENGTH_SHORT).show();
            }
            }
        }
        if(v==b2)
        {
          finish();
        }
    }
}
