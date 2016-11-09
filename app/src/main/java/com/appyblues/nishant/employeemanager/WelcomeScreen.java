package com.appyblues.nishant.employeemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomescreen);
        Runnable r=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i=new Intent(WelcomeScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }


        };
        Thread t=new Thread(r);
        t.start();
            }
    }


