package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.amu.db.DbShopController;
import com.example.amu.db.DbUsersController;
import com.example.amu.model.Shop;

public class PantallaCatalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_catalogo);
        DbUsersController dbUsers = new DbUsersController(this);
        String nombre = dbUsers.obtainName(getIntent().getExtras().getInt("idUser"));
        TextView txtNombre = findViewById(R.id.txtNombre5);
        txtNombre.setText(txtNombre.getText() + nombre);
    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(PantallaCatalogo.this, PantallaComprador.class);
        intent.putExtra("idUser", getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

    public void onClick10(View view) {
        TextView txtTotal = findViewById(R.id.textView10);
        String[] separado = txtTotal.getText().toString().split(" ");
        txtTotal.setText(separado[0] + " " + Double.toString((Double.parseDouble(separado[1]) + 10)));
    }

    public void onClick30(View view) {
        TextView txtTotal = findViewById(R.id.textView10);
        String[] separado = txtTotal.getText().toString().split(" ");
        txtTotal.setText(separado[0] + " " + (Double.parseDouble(separado[1]) + 30));
    }

    public void onClick15(View view) {
        TextView txtTotal = findViewById(R.id.textView10);
        String[] separado = txtTotal.getText().toString().split(" ");
        txtTotal.setText(separado[0] + " " + (Double.parseDouble(separado[1]) + 15));
    }

    public void onClick20(View view) {
        TextView txtTotal = findViewById(R.id.textView10);
        String[] separado = txtTotal.getText().toString().split(" ");
        txtTotal.setText(separado[0] + " " + (Double.parseDouble(separado[1]) + 20));
    }

    public void onClickComprar(View view) {
        TextView txtTotal = findViewById(R.id.textView10);
        String[] separado = txtTotal.getText().toString().split(" ");
        DbShopController dbShop = new DbShopController(this);
        dbShop.insertShop(new Shop(getIntent().getExtras().getInt("idUser"),Double.parseDouble(separado[1])));
        Intent intent = new Intent(PantallaCatalogo.this,PantallaCompra.class);
        intent.putExtra("idUser", getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

}