package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Usuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
    }


    public void onClickVender(View view) {
        Intent intent = new Intent(Usuarios.this,UsuarioVendedor.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

    public void onClickComprar(View view) {
        Intent intent = new Intent(Usuarios.this,PantallaComprador.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

    public void onClickLogOut(View view) {
        Intent intent = new Intent(Usuarios.this,MainActivity.class);
        startActivity(intent);
    }
}