package com.appyblues.nishant.employeemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nishant on 19-10-2016.
 */
public class DBHandler extends SQLiteOpenHelper {


    private static final int DBversion = 1;
    public static final String tab1 = "Employee";
    private static final String DB_NAME = "emps.db";
    public static final String EMPLOYEE_ID = "id";
    public static final String EMPLOYEE_NAME = "empname";
    public static final String EMPLOYEE_ADDRESS = "empaddress";
    public static final String EMPLOYEE_PASSWORD = "pswd";
    public static final String EMPLOYEE_PHONE = "phoneno";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + tab1 + "(" + EMPLOYEE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " + EMPLOYEE_NAME +
                "TEXT " + EMPLOYEE_ADDRESS + "TEXT" + EMPLOYEE_PASSWORD + "PASSWORD" + EMPLOYEE_PHONE + "NUMBER " + ");";
        try {
            sqLiteDatabase.execSQL(query);
        } catch (Exception ex) {
            // Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tab1);
        onCreate(sqLiteDatabase);
    }

    public void addemp(String name, String address, String pswd, int phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMPLOYEE_NAME, name);   //edit
        contentValues.put(EMPLOYEE_ADDRESS, address);
        contentValues.put(EMPLOYEE_PASSWORD, pswd);
        contentValues.put(EMPLOYEE_PHONE, phone);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tab1, null, contentValues);
        db.close();
    }


    public void fireemp(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + tab1 + "WHERE " + EMPLOYEE_ID + "=" + id + ";");
    }

    public String empprint() {
        String emps = "";
        SQLiteDatabase db = getWritableDatabase();
        String query="SELECT "+EMPLOYEE_NAME+"FROM "+tab1+"WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        if(c.getString(c.getColumnIndex(EMPLOYEE_NAME))!=null)
        {
            emps+=c.getColumnIndex(EMPLOYEE_NAME);
            emps+="\n";
        }
       db.close();
      return  emps;
    }

    public void editemp(int id,String name,String address,String pswd,int phone) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE  " + tab1 + " SET "+EMPLOYEE_NAME+"="+name+","+EMPLOYEE_ADDRESS+
                "="+address+","+EMPLOYEE_PASSWORD +"="+pswd+","+EMPLOYEE_PHONE+"="+phone+" WHERE " + EMPLOYEE_ID + "=" + id + ";");
    }

    public  void fetch(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("SELECT "+EMPLOYEE_NAME+","+EMPLOYEE_ADDRESS+","+EMPLOYEE_PASSWORD+","+EMPLOYEE_PHONE+"FROM "+tab1
                +"WHERE "+EMPLOYEE_ID + "=" + id + ";");
    }
}
