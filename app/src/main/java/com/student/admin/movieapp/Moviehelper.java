package com.student.admin.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class Moviehelper extends SQLiteOpenHelper {
    public static final String Dbname = "MyM.db";
    public static final String TableName = "Movie";
    public static final String col1 = "id";
    public static final String col2 = "mname";
    public static final String col3 = "mactor";
    public static final String col4 = "mactress";
    public static final String col5 = "ryear";
    public static final String col6 = "director";
    public static final String col7 = "producer";
    public static final String col8 = "cameraman";
    public static final String col9 = "tcollection";
    public static final String col10 = "mlanguage";
    public Moviehelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 + " text," + col8 + " text,"+col9+" text,"+col10+" text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String mname,String mactor,String mactress,String ryear,String director,String producer,String cameraman,String tcollection,String mlanguage){
SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,mname);
        contentValues.put(col3,mactor);
        contentValues.put(col4,mactress);
        contentValues.put(col5,ryear);
        contentValues.put(col6,director);
        contentValues.put(col7,producer);
        contentValues.put(col8,cameraman);
        contentValues.put(col9,tcollection);
        contentValues.put(col10,mlanguage);
        long status=sqLiteDatabase.insert(TableName,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor SearchData(String mname)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TableName+" WHERE "+col2+"='"+mname+"'",null);
        return cursor;
    }
    public boolean UpdateData(String id,String mactor,String mactress,String ryear,String director,String producer,String cameraman,String tcollection,String mlanguage)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col3,mactor);
        contentValues.put(col4,mactress);
        contentValues.put(col5,ryear);
        contentValues.put(col6,director);
        contentValues.put(col7,producer);
        contentValues.put(col8,cameraman);
        contentValues.put(col9,tcollection);
        contentValues.put(col10,mlanguage);
        long status=db.update(TableName,contentValues,col1+"="+id,null);
        if (status==-1)
        {
            return false;

        }
        else
        {
            return true;
        }


    }
    public boolean DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long status=db.delete(TableName,col1+"="+id,null);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
