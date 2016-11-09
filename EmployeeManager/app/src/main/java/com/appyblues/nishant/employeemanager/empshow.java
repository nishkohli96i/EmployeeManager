package com.appyblues.nishant.employeemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class empshow extends AppCompatActivity {
    TextView tw,as;
    DBManager df1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        df1=new DBManager(this);
        setContentView(R.layout.empshow);
        tw=(TextView)findViewById(R.id.textView31);
        as=(TextView)findViewById(R.id.textView41);
        String gf=df1.empidprint();
        tw.setText(gf);
        String gf2=df1.empnameprint();
        as.setText(gf2);
    }
}
