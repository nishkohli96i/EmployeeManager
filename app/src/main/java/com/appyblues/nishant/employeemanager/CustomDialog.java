package com.appyblues.nishant.employeemanager;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nishant on 13-11-2016.
 */
public class CustomDialog extends Dialog implements View.OnClickListener {
    Dialog dialog;
    int id;
    Button b1,b2;
    AutoCompleteTextView e1;
    String delemp;
    DBManager df;
    NotificationCompat.Builder re;
    String empids="";
    String [] empids1=new String[20];

    public CustomDialog(Context context) {
        super(context);
    }
    public void onCreate(Bundle si)
    {
        super.onCreate(si);
        setContentView(R.layout.deletedialog);
        b1=(Button)findViewById(R.id.button17);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button21);
        b2.setOnClickListener(this);
        e1=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        df=new DBManager(getContext());
        re=new NotificationCompat.Builder(getContext());
        empids=df.getempids();
        empids1=empids.split("\n");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(),android.R.layout.simple_list_item_1,empids1);
        e1.setThreshold(1);
        e1.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
     if(v==b1)
     {
         delemp = e1.getText().toString();
         if (df.deleteemp(delemp) == 1) {
             Toast.makeText(getContext(), " Employee " + df.getname(delemp) + " Fired ", Toast.LENGTH_LONG).show();
             re.setAutoCancel(true);
             re.setWhen(System.currentTimeMillis() + 100);
             re.setContentTitle("Employee Fired ");
             re.setContentText(df.getname(delemp));
         }
         else
         {
             Toast.makeText(getContext(),"Wrong Id",Toast.LENGTH_LONG).show();
         }

     }
        if(v==b2)
        {
         this.cancel();
        }
    }
}
