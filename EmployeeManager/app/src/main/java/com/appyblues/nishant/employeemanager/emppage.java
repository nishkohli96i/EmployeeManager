package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class emppage extends Activity implements View.OnClickListener {

    ImageButton ib;
    Button b1, b2, b3;
    TextView t1;
    Bundle ow;
    String qw;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emppage);
        //  Button b1=(Button)findViewById(R.id.button10);
        ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(this);
       ow = getIntent().getExtras();
       qw = ow.getString("empid");
        t1 = (TextView) findViewById(R.id.textView9);
        t1.setText(ow.getString("empid"));
        b1 = (Button) findViewById(R.id.button11);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button13);
        b3 = (Button) findViewById(R.id.button12);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        ;
        return true;
    }
    public void logout(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    @Override
    public void onClick(View view) {
        if (view == ib) {
            Toast.makeText(getBaseContext(), "clicked", Toast.LENGTH_LONG).show();
        }
        if (view == b1) {
            Intent i = new Intent(this, editprofile.class);
             i.putExtra("empid",qw);
            startActivity(i);
        }
        if (view == b3) {
        Intent iu = new Intent(this, projects.class);
        startActivity(iu);
    }
}
}

