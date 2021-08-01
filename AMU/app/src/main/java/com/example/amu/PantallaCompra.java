package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.amu.db.DbUsersController;

public class PantallaCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_compra);
        DbUsersController dbUsers = new DbUsersController(this);
        String nombre = dbUsers.obtainName(getIntent().getExtras().getInt("idUser"));
        TextView txtNombre = findViewById(R.id.txtNombre6);
        txtNombre.setText(txtNombre.getText()+nombre);
    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(PantallaCompra.this,PantallaCatalogo.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }
}