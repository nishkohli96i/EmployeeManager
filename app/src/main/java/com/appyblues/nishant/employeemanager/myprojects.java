package com.appyblues.nishant.employeemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class myprojects extends AppCompatActivity {

     DBManager df;
    ListView li;
    Bundle kl;
    String xc="",nm="";
    String[] projs=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprojects);
        kl=getIntent().getExtras();
        xc=kl.getString("empname");
        df=new DBManager(this);
        li=(ListView)findViewById(R.id.listView);
        nm=df.myprojs(xc);
        projs=nm.split("\n");
        ArrayAdapter ty = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, projs);
        li.setAdapter(ty);
    }
}
