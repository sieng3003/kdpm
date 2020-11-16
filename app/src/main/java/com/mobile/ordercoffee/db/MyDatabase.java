package com.mobile.ordercoffee.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "Product.db";
    public String TABLE_NAME = "PRODUCT";
    public String ID = "ID";
    public String NAME = "NAME";
    public String PRICE = "PRICE";
//    public String AMOUNT = "AMOUNT";
    public String TYPE = "TYPE";
    public String IMAGE = "IMAGE";


    public MyDatabase (Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    /**
     * chỉ chạy duy nhất lần đầu cài app, đã cài có sửa cũng không được cập nhật nhé.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format(
                "CREATE TABLE %s "
                        + "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT)", TABLE_NAME, ID, NAME, PRICE, TYPE, IMAGE);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public  boolean addProduct(String name, String price, String type, String image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PRICE, price);
//        values.put(AMOUNT, amount);
        values.put(TYPE, type);
        values.put(IMAGE, image);

        // Inserting Row
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateProduct(String id, String name, String price, String type, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(PRICE, price);
//        values.put(AMOUNT, amount);
        values.put(TYPE, type);
        values.put(IMAGE, image);
        db.update(TABLE_NAME, values, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteProduct(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    public Cursor getAllContact() {
        SQLiteDatabase mDb = this.getWritableDatabase();
        Cursor mCursor = mDb.query(TABLE_NAME, new String[]{ID,
                        NAME, PRICE, TYPE, IMAGE},
                null, null, null, null, null);
        return mCursor;
    }



}
