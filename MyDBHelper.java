package com.example.mario.user_draft;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import java.util.LinkedList;
import java.util.List;


public class MyDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BlutApp.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERFIRSTNAME = "userfirstname";
    public static final String COLUMN_USERLASTNAME = "userlastname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_DOB = "DOB";
    //public static final String COLUMN_GEN = "GEN";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERFIRSTNAME + " TEXT, " +
                COLUMN_USERLASTNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_DOB + " TEXT" +
                //COLUMN_GEN + " TEXT" +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(Users user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERFIRSTNAME, user.get_usernamefirst());
        values.put(COLUMN_USERLASTNAME, user.get_usernamelast());
        values.put(COLUMN_EMAIL, user.get_email());
        values.put(COLUMN_DOB, user.get_DOB());
        //values.put(COLUMN_GEN, user.get_GEN());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public void clearTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_USERS, null, null);
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);
        return c;
    }

    public String db2String() {
        SQLiteDatabase db = this.getWritableDatabase();
        String dbString ="";
        String query = "SELECT * FROM " + TABLE_USERS;

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("_id")) != null) {
                dbString += c.getString(c.getColumnIndex("userfirstname"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;


    }
}
