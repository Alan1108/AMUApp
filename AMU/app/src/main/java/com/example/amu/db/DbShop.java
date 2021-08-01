package com.example.amu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbShop extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "AMU.DbShops";
    public static final String TABLE_SHOPS = "SHOPS";

    public DbShop(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_SHOPS + "(" +
                "idShop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUser INTEGER NOT NULL," +
                "total DOUBLE NOT NULL," +
                "FOREIGN KEY(idUser) REFERENCES USERS(id))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_SHOPS);
        onCreate(db);
    }
}
