package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nishant on 13-10-2016.
 */
public class About extends Activity {
    Button b1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iu=new Intent(About.this,MainActivity.class);
                startActivity(iu);
            }
        });
    }
}
