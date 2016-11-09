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
    String[] projs = {"C++", "Java", "Python", "R.Programming", "SQL", "PHP"};
    ListView as;
    TextView t1;
    DBManager qw;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*  setContentView(R.layout.projects);
      as=(ListView)findViewById(R.id.listView);
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
    */
         setContentView(R.layout.viewprojs);
        t1=(TextView)findViewById(R.id.textView38);
        qw=new DBManager(this);
        String we=qw.projprint();
        t1.setText(we);
        t1.setEditableFactory(null);
    }

}


