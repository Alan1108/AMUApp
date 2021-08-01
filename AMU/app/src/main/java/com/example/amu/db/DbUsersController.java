package com.example.amu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.amu.model.Person;

public class DbUsersController extends DbUsers {

    Context context;

    public DbUsersController(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertUser(Person person){
        long id = 0;
        try{
            DbUsers dbUsersHelper = new DbUsers(context);
            SQLiteDatabase db = dbUsersHelper.getWritableDatabase();
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
        DbUsers dbUsersHelper = new DbUsers(context);
        SQLiteDatabase db = dbUsersHelper.getWritableDatabase();
        Cursor cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email = '" + email
                + "' AND password = '"+password+"'",null);
        if(cursorUsers.moveToFirst()){
            return true;
        }else{
            return false;
        }

    }

    public int obtainId(String email, String password){
        DbUsers dbUsersHelper = new DbUsers(context);
        SQLiteDatabase db = dbUsersHelper.getWritableDatabase();
        Cursor cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email = '" + email
                + "' AND password = '"+password+"'",null);
        if(cursorUsers.moveToFirst()){
            return cursorUsers.getInt(0);
        }
        return 0;
    }

    public String obtainName(int idUser){
        DbUsers dbUsersHelper = new DbUsers(context);
        SQLiteDatabase db = dbUsersHelper.getWritableDatabase();
        Cursor cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE id ="+idUser,null);
        if(cursorUsers.moveToFirst()){
            return cursorUsers.getString(1)+" "+cursorUsers.getString(2);
        }
        return "";
    }
}
