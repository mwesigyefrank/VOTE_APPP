package com.example.amustvote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlTest extends SQLiteOpenHelper {
    public SqlTest(Context context){
        super(context ,"candidate.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL ( "CREATE TABLE candidates(ID integer not null primary key autoincrement,name varchar(40),position varchar(30),fee integer(68),course varchar(40))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion) {
        db.execSQL ( "DROP TABLE if exists candidates " );
        onCreate ( db );
    }
    public boolean saveDate(String name, String pos, int fee,String course){
        SQLiteDatabase db=this.getWritableDatabase ();
        ContentValues contentValues=new ContentValues (  );
        contentValues.put ( "name",name );
        contentValues.put ( "position",pos );
        contentValues.put ( "fee",fee );
        contentValues.put ( "course",course );
        long insert=db.insert ( "candidates",null,contentValues);
        if (insert==-1){
            return false;
        }
        else return true;

    }
    public Cursor getData(){
        SQLiteDatabase db=this.getReadableDatabase ();
        Cursor data=db.rawQuery ( "SELECT * FROM candidates",null );
        return data;
    }
}
