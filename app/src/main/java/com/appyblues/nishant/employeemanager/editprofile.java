package com.appyblues.nishant.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Nishant on 18-10-2016.
 */
public class editprofile extends Activity implements View.OnClickListener {
    Button b1;
    EditText t1,t2,t3,t4,t5,t6;
    DBManager dv;
    Bundle ki;
    String ty="",kl,qw;
    String [] empdata=new String[4];
    private static final int SELECT_PICTURE_GALLERY = 1;
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageButton imageButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);
        b1=(Button)findViewById(R.id.button14);
        final Bundle ows=getIntent().getExtras();
        dv=new DBManager(this);
        b1.setOnClickListener(this);
        ki=getIntent().getExtras();
        ty=ki.getString("empid");
        t1=(EditText) findViewById(R.id.editText6);
        t2=(EditText) findViewById(R.id.editText7);
        t3=(EditText) findViewById(R.id.editText8);
        t4=(EditText) findViewById(R.id.editText9);
        t5=(EditText) findViewById(R.id.editText10);
        t6 = (EditText)findViewById(R.id.editText24);
        imageButton=(ImageButton)findViewById(R.id.imageButton3);
        imageButton.setOnClickListener(this);
      try{
          empdata=dv.getdata(ty);
        t1.setText(empdata[0]);
        t2.setText(empdata[1]);
        t3.setText(empdata[2]);
        qw=empdata[3];
        kl=empdata[4];
        imageButton.setImageURI(Uri.parse(kl));

    }
      catch  (Exception ex)
      {
          Toast.makeText(this,ty,Toast.LENGTH_SHORT).show();
      Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
      }
    }

    public void fetchGallery(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            imageButton.setImageURI(selectedImage);
            kl=selectedImage.toString();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            if (t6.getText().toString().equals(qw) && t4.getText().toString().equals("") && t5.getText().toString().equals("")) {
                dv.updateemp(ty, t1.getText().toString(), t2.getText().toString(),t3.getText().toString(),qw,kl);
                finish();
            }
            else
            if(t6.getText().toString().equals(qw) && t4.getText().toString().equals(t5.getText().toString()))
            {
                dv.updateemp(ty, t1.getText().toString(), t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),kl);
                finish();
            }
            else if(!t4.getText().toString().equals(t5.getText().toString()))
            {
                Toast.makeText(this,"New Passwords do not match",Toast.LENGTH_SHORT).show();
            }
        else if(!t6.getText().toString().equals(""))
            {
                Toast.makeText(this," Wrong Password ",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this," Please Enter Your  Password ",Toast.LENGTH_SHORT).show();
            }
        }
        if(v==imageButton)
        {
         fetchGallery(imageButton);
        }
    }
}
