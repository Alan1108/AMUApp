package com.example.amu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbSales extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "AMU.DbSales";
    public static final String TABLE_SALES = "SALES";

    public DbSales(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_SALES + "(" +
                "idSale INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUser INTEGER NOT NULL," +
                "price DOUBLE NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "fecha DATE NOT NULL," +
                "FOREIGN KEY(idUser) REFERENCES USERS(id))"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_SALES);
        onCreate(db);
    }
}
