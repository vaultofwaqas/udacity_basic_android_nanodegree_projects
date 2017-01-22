package com.waqkz.Inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Waqas on 9/5/2016.
 */
public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_INVENTORY_TABLE=
                "CREATE TABLE " + InventoryContract.InventoryEntry.TABLE_NAME + " (" +
                        InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME + " TEXT  NOT NULL, " +
                        InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY + " INTEGER NOT NULL DEFAULT 0, " +
                        InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE + " INTEGER NOT NULL," +
                        InventoryContract.InventoryEntry.COLUMN_INVENTORY_KEY_IMAGE + " BLOB);";


        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
