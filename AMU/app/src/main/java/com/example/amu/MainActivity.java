package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amu.db.dbHelper;
import com.example.amu.db.dbUsers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper dbhelper = new dbHelper(MainActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        if(db==null){
            Toast.makeText(this,"HUBO UN ERROR CON LA BASE DE DATOS!",Toast.LENGTH_LONG).show();
        }
    }

    public void onClickAbout(View view) {
        Intent intent = new Intent(MainActivity.this,About.class);
        startActivity(intent);

    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){
        dbUsers db = new dbUsers(MainActivity.this);
        EditText email = findViewById(R.id.txtEmail);
        EditText password = findViewById(R.id.txtPassword);
        String emailS =email.getText().toString();
        String passwordS =password.getText().toString();
        if(db.readUser(emailS,passwordS)){
            mostrarDialogo("BIENVENIDO!!");
            email.setText("");
            password.setText("");
            Intent intent = new Intent(MainActivity.this,PaginaPrincipal.class);
            startActivity(intent);
        }else{
            mostrarDialogo("Email o Contraseña erroneos vuelva a intentar!!");
            email.setText("");
            password.setText("");
        }
    }

    public void mostrarDialogo(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}