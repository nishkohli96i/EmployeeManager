package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nishant on 19-10-2016.
 */
public class projects extends Activity {
    String[] projs=new String[20];
    ListView as;
    TextView t1;
    DBManager qw;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewprojs);
        qw=new DBManager(this);
        String we=qw.projprint();
        projs=we.split("\n");
         setContentView(R.layout.viewprojs);
      as=(ListView)findViewById(R.id.listView2);
        ArrayAdapter ty = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projs);
        as.setAdapter(ty);

        as.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),"You have selected "+projs[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onListItemClick(ListView lv, View vi, int position, long id)
    {
        Toast.makeText(getBaseContext(),"You have selected "+projs[position], Toast.LENGTH_SHORT).show();
    }

    }



