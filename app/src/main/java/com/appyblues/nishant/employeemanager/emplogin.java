package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class emplogin extends Activity implements View.OnClickListener {
      EditText t1,t2;
    Button b1,b2;
    DBManager dbManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplogin);
        t1=(EditText)findViewById(R.id.editText2);
        t2=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button6);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button9);
        b2.setOnClickListener(this);
        dbManager=new DBManager(this);
    }

    public void onClick(View view) {

         if(view==b1)
         {
             if (t1.getText().toString().equals("") || t2.getText().toString().equals(""))
             {
                 Toast.makeText(getBaseContext(), "Please fill All the Fields", Toast.LENGTH_SHORT).show();
                 t1.setText("");
                 t2.setText("");
             }
             else
             if ( dbManager.checkemp(t1.getText().toString(),t2.getText().toString()) )
             {
               try{
                 Toast.makeText(getBaseContext(), " Welcome " +t1.getText().toString(), Toast.LENGTH_SHORT).show();
                 Intent i=new Intent(this,emppage.class);
                   String tr=t1.getText().toString();
                   t1.setText("");
                   t2.setText("");
             //      i.putExtra("empname",dbManager.getname(tr));
                   i.putExtra("empid",(tr));
                 startActivity(i);
             }
               catch (Exception ex)
               {Toast.makeText(getBaseContext(),ex.getMessage(), Toast.LENGTH_LONG).show();
               }
             }
             else {
                 Toast.makeText(getBaseContext(), "Wrong User Details", Toast.LENGTH_SHORT).show();
                 t1.setText("");
                 t2.setText("");
             }
         }

        if(view==b2)
        {
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}
