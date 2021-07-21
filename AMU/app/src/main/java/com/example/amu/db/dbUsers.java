package com.example.amu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.amu.Person;

import java.util.ArrayList;

public class dbUsers extends dbHelper{

    Context context;

    public dbUsers(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertUser(Person person){
        long id = 0;
        try{
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",person.getName());
            values.put("lastName",person.getLastName());
            values.put("user",person.getUser());
            values.put("email",person.getEmail());
            values.put("password",person.getPassword());

            id = db.insert(TABLE_USERS,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public boolean readUser(String email, String password){
        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email = '" + email
                + "' AND password = '"+password+"'",null);
        if(cursorUsers.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }
}
