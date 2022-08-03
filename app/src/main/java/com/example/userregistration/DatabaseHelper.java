package com.example.userregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="users.db";
    public static final String TABLE_NAME="users_data";
    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="DATE_OF_BIRTH";
    public static final String COL4="EMAIL_ID";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT, DATE_OF_BIRTH, EMAI_ID) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }

    public boolean addData(String dName, String dDOB, String demail_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,dName);
        contentValues.put(COL3,dDOB);
        contentValues.put(COL2,demail_id);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result== -1 ){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null );
        return data;
    }

}
