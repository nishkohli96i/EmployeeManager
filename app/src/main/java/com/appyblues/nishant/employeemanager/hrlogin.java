package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nishant on 05-10-2016.
 */
public class hrlogin extends Activity
{
    Button b1,b2;
    EditText t1,t2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hrlogin);
        t1=(EditText)findViewById(R.id.editText4);
        t2=(EditText)findViewById(R.id.editText5);
        b1 = (Button) findViewById(R.id.button7);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((t1.getText().toString().equals("123") && t2.getText().toString().equals("Nish"))
                     ||(t1.getText().toString().equals("1") && t2.getText().toString().equals("N"))
                        )
                {
                    Intent iu = new Intent(hrlogin.this, hrpage.class);
                   iu.putExtra("hrname",t1.getText().toString());

                    t1.setText("");
                    t2.setText("");
                    startActivity(iu);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Wrong username/password",Toast.LENGTH_LONG).show();
                    t1.setText(""); t2.setText("");
                }
            }
        });
        b2 = (Button) findViewById(R.id.button8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iu=new Intent(hrlogin.this,MainActivity.class);
                startActivity(iu);
            }
        });
    }
}
