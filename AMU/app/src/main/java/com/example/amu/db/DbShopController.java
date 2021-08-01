package com.example.amu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.amu.model.Sale;
import com.example.amu.model.Shop;

public class DbShopController extends DbShop{

    Context context;

    public DbShopController(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertShop(Shop shop){
        long id = 0;
        try{
            DbSales dbSalesHelper = new DbSales(context);
            SQLiteDatabase db = dbSalesHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("idUser",shop.getIdUser());
            values.put("total",shop.getTotal());
            id = db.insert(TABLE_SHOPS,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
