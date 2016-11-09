package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nishant on 13-10-2016.
 */
public class hrpage extends Activity implements View.OnClickListener{
    Button b1,b2,b3,b4,b5,b6;
    TextView ty;
    Bundle ki;
    ImageView imageView;
    private String delemp="";
    DBManager df;


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


    public void confdelete()
    {
AlertDialog.Builder qw=new AlertDialog.Builder(this);
        qw.setTitle("Confirm Delete ");
        qw.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        qw.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             //   this.setCancelable(true);
            }
        });
        qw.show();
    }


    @Override
    public void onClick(View view) {
        if(view==b1)
        {
            Intent iu=new Intent(this,addemp.class);
            startActivity(iu);
        }

        if (view==b2)
        {
            final Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.deletedialog);
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
