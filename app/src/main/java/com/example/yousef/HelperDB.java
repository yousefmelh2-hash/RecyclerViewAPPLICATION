package com.example.yousef;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "items.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ITEMS = "items";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_LASTNAME = "lastname";
    private static final String COL_PHOTOID = "photoid";

    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS "+TABLE_ITEMS
                +" ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_NAME+" TEXT, "
                + COL_LASTNAME + " TEXT, "
                + COL_PHOTOID + " TEXT)";
        db.execSQL(sql);
    }
    public void addItem(Item item){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_NAME, item.getName());
        values.put(COL_LASTNAME,item.getLastName());
        values.put(COL_PHOTOID, item.getPhotoID());
        db.insert(TABLE_ITEMS,null,values);
        db.close();
    }
    private Item cursorToItem(Cursor cursor){

        return new Item(

                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(0)
        );
    }
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery(
             "SELECT "+COL_ID+", "+COL_NAME+", " +COL_LASTNAME+", "+COL_PHOTOID
                +" FROM "+TABLE_ITEMS,null);
        while (cursor.moveToNext()){
             addItem(cursorToItem(cursor));
        }
    cursor.close();
    db.close();
    return items;
    }
    public ArrayList<Item> getItemsByTitle(String name){// gets specific coloumn with
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery(
                "SELECT "+COL_ID+", "+COL_NAME+", "
                +COL_LASTNAME+", "+COL_PHOTOID
                +" FROM "+  TABLE_ITEMS
                +" WHERE "+COL_NAME +" = ?",
                new String[]{name});
        while (cursor.moveToNext()){
            addItem(cursorToItem(cursor));
        }
        cursor.close();
        db.close();
        return items;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerison){}
}