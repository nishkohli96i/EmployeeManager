package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nishant on 13-10-2016.
 */
public class hrpage extends Activity implements View.OnClickListener{
    Button b1,b2,b4,b5,b6,b7,b8;
    TextView ty;
    Bundle ki;
    ImageView imageView;
    private String delemp="";
    DBManager df;
    EditText e1;
    NotificationCompat.Builder re;
    AutoCompleteTextView e2;
    String delemp1,empids;
    String [] empids1=new String[20];
    int UNIQUE_ID=1244;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hrpage);
        ty=(TextView)findViewById(R.id.textView25);
        df=new DBManager(this);

        b1=(Button)findViewById(R.id.button19);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button20);
        b2.setOnClickListener(this);
        b4=(Button)findViewById(R.id.button22);
        b4.setOnClickListener(this);
        b5=(Button)findViewById(R.id.button15);
        b5.setOnClickListener(this);
        b6=(Button)findViewById(R.id.button25);
        b6.setOnClickListener(this);
        imageView=(ImageView)findViewById(R.id.imageView3);
        ki=new Bundle();
        ki=getIntent().getExtras();
        String hu=ki.getString("hrname");
        ty.setText(hu);

       if(hu.equals("123"))
        {
            imageView.setImageResource(R.drawable.ic_menu_camera);
                    //(R.drawable.q1);
        }
        else
            imageView.setImageResource(R.drawable.ic_menu_share);

    }


    @Override
    public void onClick(View view) {
        if(view==b1)
        {
            Intent iu=new Intent(this,addemp.class);
            startActivity(iu);
        }


        if(view==b2) {
            final Dialog c=new Dialog(this);
            c.setContentView(R.layout.deletedialog);
            c.setTitle("Fire an employee");
            b7=(Button)c.findViewById(R.id.button17);
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delemp = e2.getText().toString();
                    if(e2.getText().toString().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Field Empty",Toast.LENGTH_SHORT).show();
                    }
                    if (df.deleteemp(delemp) == 1) {
                        Toast.makeText(getBaseContext(), " Employee " + df.getname(delemp) + " Fired ", Toast.LENGTH_LONG).show();
                    /*    re.setAutoCancel(true);
                        re.setWhen(System.currentTimeMillis() + 100);
                        re.setContentTitle("Employee Fired ");
                        re.setContentText(df.getname(delemp));
                      */
                        e2.setText("");
                  /*      Intent i = new Intent(getApplicationContext(), empshow.class);
                        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        re.setContentIntent(pi);
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(UNIQUE_ID, re.build());
                    */
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"Wrong Id",Toast.LENGTH_LONG).show();
                    }
                }

            });
            b8=(Button)c.findViewById(R.id.button21);
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c.dismiss();
                }
            });
            e2=(AutoCompleteTextView)c.findViewById(R.id.autoCompleteTextView);
            re=new NotificationCompat.Builder(this);
            empids=df.getempids();
            empids1=empids.split("\n");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this,android.R.layout.simple_list_item_1,empids1);
            e2.setThreshold(1);
            e2.setAdapter(adapter);
            c.show();

             }
        if (view==b4)
        {
            Intent iu=new Intent(this,projects.class);
            startActivity(iu);
        }
        if (view==b5)
        {
            Intent iu=new Intent(this,empshow.class);
            startActivity(iu);
        }
        if(view ==b6)
        {
            Intent iu=new Intent(this,addproject.class);
            startActivity(iu);
        }

    }


}
