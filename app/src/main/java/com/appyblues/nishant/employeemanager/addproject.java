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
    Button done,b2,b3;
    EditText t1,t2;
    AutoCompleteTextView tv;
    DBManager hg;
    String empnames,kl="";
    String [] names=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproject);
        done=(Button)findViewById(R.id.button24);
        done.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button27);
        b2.setOnClickListener(this);
        b3=(Button)findViewById(R.id.button18);
        b3.setOnClickListener(this);
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
        tv.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v == b3) {
            if (!t1.getText().toString().equals(" "))
            {
                if(hg.isdupprojname(t1.getText().toString())==0)
                {Toast.makeText(this, " Project " + t1.getText().toString() + "  Added ", Toast.LENGTH_SHORT).show();
                    hg.addnewproj(t1.getText().toString(), t2.getText().toString(), "");
                    tv.setVisibility(View.VISIBLE);
                    done.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    Toast.makeText(this, "Please Add Some Employees To The Project", Toast.LENGTH_LONG).show();
                }
            else
                {
                    Toast.makeText(this, "Project Name Already Exists", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this, "Enter The Project Name", Toast.LENGTH_SHORT).show();
            }
            }
        if (v == b2) {
            finish();
        }
        if (v == done) {
            if (tv.getText().toString().equals("")) {
                Toast.makeText(this, "Enter an Employee Name First!!", Toast.LENGTH_LONG).show();
            }
            kl = hg.getprojemps(t1.getText().toString());
            int y = hg.isnamepresent(kl, tv.getText().toString());
            if (y == 1) {
                Toast.makeText(this, "Employee Already there in the project", Toast.LENGTH_LONG).show();
            }
            else if (!tv.getText().toString().equals("")) {
                if (hg.isempnameexist(tv.getText().toString()) == 1) {
                    kl = kl + "\n" + tv.getText().toString();
                    hg.updateproj(t1.getText().toString(), t2.getText().toString(), kl);
                    Toast.makeText(this, "Employee Added To The project", Toast.LENGTH_LONG).show();
                    tv.setText("");
                } else {
             Toast.makeText(this,"No Such Employee Found in records",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
