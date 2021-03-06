package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.amu.db.DbUsersController;

public class PantallaRetiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_retiro);
        DbUsersController dbUsers = new DbUsersController(this);
        String nombre = dbUsers.obtainNameEnterprise(getIntent().getExtras().getInt("idUser"));
        TextView txtNombre = findViewById(R.id.txtNombre3);
        txtNombre.setText(txtNombre.getText()+nombre);
    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(PantallaRetiro.this,UsuarioVendedor.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }
}