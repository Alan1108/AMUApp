package com.example.amu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.amu.model.Sale;

import java.sql.Date;
import java.util.ArrayList;

public class DbSalesController extends DbSales{

    Context context;

    public DbSalesController(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertSale(Sale sale){
        long id = 0;
        try{
            DbSales dbSalesHelper = new DbSales(context);
            SQLiteDatabase db = dbSalesHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("idUser",sale.getIdUser());
            values.put("price",sale.getTotalPrice());
            values.put("descripcion",sale.getDescripcion());
            values.put("fecha",sale.getFecha().toString());
            id = db.insert(TABLE_SALES,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Sale> readSales(int idUser){
        DbSales dbSalesHelper = new DbSales(context);
        SQLiteDatabase db = dbSalesHelper.getWritableDatabase();
        ArrayList<Sale> sales = new ArrayList<>();
        Sale sale;
        Cursor cursorSale = null;

        cursorSale = db.rawQuery("SELECT * FROM SALES WHERE idUser = " + idUser+";",null);

        if(cursorSale.moveToFirst()){
            do{
                String[] fecha = cursorSale.getString(4).split("-");
                Date date = new Date(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]));
                sales.add(new Sale(idUser,cursorSale.getDouble(2),cursorSale.getString(3),date));
            }while(cursorSale.moveToNext());
        }

        cursorSale.close();

        return sales;
    }
}
