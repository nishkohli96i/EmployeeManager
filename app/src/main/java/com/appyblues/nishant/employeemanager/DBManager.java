package com.appyblues.nishant.employeemanager;

import android.content.*;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBManager extends SQLiteOpenHelper {
    String emps = "";
    String aas = "";
    private static final int DBversion = 1;
    public static final String tab1 = "Employee";
    private static final String DB_NAME = "emps.db";
    public static final String EMPLOYEE_ID = "empid";
    public static final String EMPLOYEE_NAME = "empname";
    public static final String EMPLOYEE_ADDRESS = "empaddress";
    public static final String EMPLOYEE_PASSWORD = "pswd";
    public static final String EMPLOYEE_PHONE = "phoneno";
    public static final String EMPLOYEE_DP = "empdp";
    public static final String tab2 = "Projects";
    public static final String PROJ_NAME = "projname";
    public static final String PROJ_DESCRIBE = "description";
    public static final String PROJ_MEMBERS = "members";

    public DBManager(Context context) {
        super(context, DB_NAME, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tab1 + " (" + EMPLOYEE_ID + " PRIMARYKEY VARCHAR not null, " +
                EMPLOYEE_NAME + " VARCHAR not null," + EMPLOYEE_ADDRESS +
                " VARCHAR not null," + EMPLOYEE_PHONE + " VARCHAR," + EMPLOYEE_PASSWORD + " VARCHAR not null,"
                + EMPLOYEE_DP + " VARCHAR);");

        String query = "create table " + tab2 + " ( " + PROJ_NAME + " primarykey varchar  not null ,"
                + PROJ_DESCRIBE + " varchar ," + PROJ_MEMBERS + " varchar not null );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tab1);
        onCreate(sqLiteDatabase);
    }

    public void addemp(String username, String name, String address, String pswd, String phone, String dp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMPLOYEE_ID, username);
        contentValues.put(EMPLOYEE_NAME, name);
        contentValues.put(EMPLOYEE_ADDRESS, address);
        contentValues.put(EMPLOYEE_PASSWORD, pswd);
        contentValues.put(EMPLOYEE_PHONE, phone);
        contentValues.put(EMPLOYEE_DP, dp);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tab1, null, contentValues);
        db.close();
    }

    public String empidprint() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + tab1;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                emps += c.getString(c.getColumnIndex(EMPLOYEE_ID));
                emps += "\n";
            } while (c.moveToNext());
        }
        db.close();
        return emps;
    }

    public String empnameprint() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + tab1;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                aas += c.getString(c.getColumnIndex(EMPLOYEE_NAME));
                aas += "\n";
            } while (c.moveToNext());
        }
        db.close();
        return aas;
    }


    void addnewproj(String name, String desc, String members) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROJ_NAME, name);
        contentValues.put(PROJ_DESCRIBE, desc);
        contentValues.put(PROJ_MEMBERS, members);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tab2, null, contentValues);
        db.close();
    }

    public String projprint() {
        SQLiteDatabase db = getWritableDatabase();
        String gh="";
        String query = "SELECT *" + " FROM " + tab2 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                gh += c.getString(c.getColumnIndex(PROJ_NAME));
                gh+= "\n";
            } while (c.moveToNext());
        }
        db.close();
        return gh;
    }

    public String getempids() {
        String cv="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT "+EMPLOYEE_ID + " FROM " + tab1 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                cv += c.getString(c.getColumnIndex(EMPLOYEE_ID));
                cv += "\n";
            } while (c.moveToNext());
        }
        db.close();
        return cv;
    }

    public int deleteemp(String id) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT "+EMPLOYEE_ID + " FROM " + tab1 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if(c.getString(c.getColumnIndex(EMPLOYEE_ID)).equals(id))
                {
                    db.delete(tab1, EMPLOYEE_ID + "=" + "'" + id + "'", null);
                    return 1;
                }
            }while (c.moveToNext());
            }
       return 0;
    }

    public boolean checkemp(String id, String pswd) {
        SQLiteDatabase db = getWritableDatabase();
        int flag = 0;
        String query = "SELECT * FROM " + tab1;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if (c.getString(c.getColumnIndex(EMPLOYEE_ID)).equals(id) && c.getString(c.getColumnIndex(EMPLOYEE_PASSWORD)).equals(pswd)) {
                    {
                        flag = 1;
                        break;
                    }
                }
            } while (c.moveToNext());
        }
        if (flag == 1)
            return true;
        return false;
    }

    public String[] getdata(String id) {
        String res[] = new String[5];
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT *  FROM " + tab1 + " WHERE " + EMPLOYEE_ID + " ='" + id + "'";
        Cursor c = db.rawQuery(query, null);
        int q1 = c.getColumnIndex(EMPLOYEE_NAME);
        int q2 = c.getColumnIndex(EMPLOYEE_ADDRESS);
        int q3 = c.getColumnIndex(EMPLOYEE_PHONE);
        int q4 = c.getColumnIndex(EMPLOYEE_PASSWORD);
        int q5 = c.getColumnIndex(EMPLOYEE_DP);
        if (c.moveToFirst()) {
            do {
                res[0] = c.getString(q1);
                res[1] = c.getString(q2);
                res[2] = c.getString(q3);
                res[3] = c.getString(q4);
                res[4] = c.getString(q5);

            } while (c.moveToNext());
        }
        return res;
    }

    public String getname(String id) {
        String ty="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + tab1 + " where " + EMPLOYEE_ID + " = '" + id + "'";
        Cursor c = db.rawQuery(query, null);
        int q1=c.getColumnIndex(EMPLOYEE_NAME);
        if (c.moveToFirst()) {
            do {
        ty = c.getString(q1);
         } while (c.moveToNext());
        }
        return ty;
    }

    public void updateemp(String id, String name, String address, String phone, String password,String dp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EMPLOYEE_ID, id);
        cv.put(EMPLOYEE_NAME, name);
        cv.put(EMPLOYEE_ADDRESS, address);
        cv.put(EMPLOYEE_PHONE, phone);
        cv.put(EMPLOYEE_PASSWORD, password);
        cv.put(EMPLOYEE_DP,dp);
        db.update(tab1, cv, EMPLOYEE_ID + "='" + id + "'", null);
        db.close();
    }

    public String getimg(String id) {
        String ty="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + tab1 + " where " + EMPLOYEE_ID + " = '" + id + "'";
        Cursor c = db.rawQuery(query, null);
        int q1=c.getColumnIndex(EMPLOYEE_DP);
        if (c.moveToFirst()) {
            do {
                ty = c.getString(q1);
            } while (c.moveToNext());
        }
        return ty;
    }

    public int isdupusername(String id) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + EMPLOYEE_ID + " FROM " + tab1 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if (id.equals(c.getString(c.getColumnIndex(EMPLOYEE_ID))))
                    return 1;
            } while (c.moveToNext());

        }
        db.close();
       return 0;
    }
public String getprojemps(String projname) {
    String qas = "";
    SQLiteDatabase db = getWritableDatabase();
    String query = "SELECT * FROM " + tab2 + " where " + PROJ_NAME + " = '" + projname + "';";
    Cursor c = db.rawQuery(query, null);
    int q1 = c.getColumnIndex(PROJ_MEMBERS);
    if (c.moveToFirst()) {
        do {
            qas = qas + c.getString(c.getColumnIndex(PROJ_MEMBERS));
            qas += "\n";
        } while (c.moveToNext());
    }
    return qas;
}

    public void updateproj(String projname,String desc,String members)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PROJ_NAME,projname);
        cv.put(PROJ_DESCRIBE,desc);
        cv.put(PROJ_MEMBERS,members);
        db.update(tab2, cv, PROJ_NAME + "='" + projname + "'", null);
        db.close();
    }
    public int isnamepresent(String projemps,String name)
    {
        if(projemps.contains(name))
        return 1;
        return 0;
    }
    public int isdupprojname(String newprojname)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " +PROJ_NAME + " FROM " + tab2 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if (newprojname.equals(c.getString(c.getColumnIndex(PROJ_NAME))))
                    return 1;
            } while (c.moveToNext());

        }
        db.close();
        return 0;
    }

    public int isempnameexist(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + EMPLOYEE_NAME + " FROM " + tab1 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if (name.equals(c.getString(c.getColumnIndex(EMPLOYEE_NAME))))
                    return 1;
            } while (c.moveToNext());
        }
        db.close();
        return 0;
    }

    public String myprojs(String name)
    {
        String gj="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT  * FROM " + tab2 + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.moveToFirst()) {
            do {
                if ((c.getString(c.getColumnIndex(PROJ_MEMBERS))).contains(name))
                {
                    gj=gj+c.getString(c.getColumnIndex(PROJ_NAME));
                    gj+="\n";
                }
            } while (c.moveToNext());
        }
        return  gj;
    }
}
