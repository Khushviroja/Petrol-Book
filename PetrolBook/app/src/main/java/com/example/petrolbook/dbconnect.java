package com.example.petrolbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

public class dbconnect extends SQLiteOpenHelper {
    public static final String Database = "Company";
    public static final String Table = "Vehicle";
    public static final String Col_1 = "id";
    public static final String Col_2 = "name";
    public static final String Col_3 = "mno";
    public static final String Col_4 = "vno";
    public static final String Col_5 = "skm";
    public static final String Col_6 = "date";
    public static final String Col_7 = "price";

    public dbconnect(@Nullable Context context){
        super (context, Database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table if not exists "+Table+ "(id integer "+
                "primary key autoincrement, name text, mno integer, vno text, skm integer, date integer, price integer)";
        Log.i("sql",sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){
        sqLiteDatabase.execSQL("drop table "+ Table);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String mno, String vno, String skm, String data, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2,name);
        values.put(Col_3,mno);
        values.put(Col_4,vno);
        values.put(Col_5,skm);
        values.put(Col_6,data);
        values.put(Col_7,price);
        long result = db.insert(Table, null,values);
        return (result == -1)?false:true;
    }

    public Cursor selectData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Table,null,null,null,null,null,null);
    }
}
