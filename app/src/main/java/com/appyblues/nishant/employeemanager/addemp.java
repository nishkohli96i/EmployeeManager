package com.appyblues.nishant.employeemanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class addemp extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_IMAGE = 1;
    Button b2;
    ImageButton b1;
    EditText t1, t2, t3, t4, t5, t6;
    DBManager df1 = new DBManager(this);
    private static int UNIQUE_ID = 3234;
    NotificationCompat.Builder re;
    private static final int RESULT_LOAD_IMAGE = 1;
    String imgpath = "";

    public void fetchGallery(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            b1.setImageURI(selectedImage);
            imgpath=selectedImage.toString();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemp);
        t1 = (EditText) findViewById(R.id.editText17);
        t2 = (EditText) findViewById(R.id.editText3);
        t3 = (EditText) findViewById(R.id.editText21);
        t4 = (EditText) findViewById(R.id.editText19);
        t5 = (EditText) findViewById(R.id.editText20);
        t6 = (EditText) findViewById(R.id.editText16);
        b1 = (ImageButton) findViewById(R.id.imageButton2);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button23);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (t1.getText().toString().equals("") || t2.getText().toString().equals("") || t3.getText().toString().equals("") ||
                            t4.getText().toString().equals("") || t5.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
                    } else if (t5.getText().toString().equals(t6.getText().toString())) {
                        if (df1.isdupusername(t1.getText().toString()) != 1) {
                            re = new NotificationCompat.Builder(getApplicationContext());
                            re.setAutoCancel(true);
                            re.setSmallIcon(R.drawable.images);
                            re.setWhen(System.currentTimeMillis() + 100);
                            re.setContentTitle("New Employee Added");
                            re.setContentText(t2.getText().toString());
                            Intent i = new Intent(getApplicationContext(), empshow.class);
                            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                            re.setContentIntent(pi);

                            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            nm.notify(UNIQUE_ID, re.build());
                            df1.addemp(t1.getText().toString(), t2.getText().toString(), t3.getText().toString(), t5.getText().toString(), (t4.getText().toString()), imgpath);
                            Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Username Already Exists ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords Do not Match", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    @Override
    public void onClick(View view) {
        if (view == b1) {
            fetchGallery(b1);
            }
        }
    }