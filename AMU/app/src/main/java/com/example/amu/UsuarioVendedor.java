package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.amu.adapters.ListaSalesAdapter;
import com.example.amu.db.DbSales;
import com.example.amu.db.DbSalesController;
import com.example.amu.db.DbUsers;
import com.example.amu.db.DbUsersController;
import com.example.amu.model.Sale;

import java.util.ArrayList;

public class UsuarioVendedor extends AppCompatActivity {

    RecyclerView listaVentas;
    ArrayList<Sale> sales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_vendedor);
        listaVentas = findViewById(R.id.listVentas);
        listaVentas.setLayoutManager(new LinearLayoutManager(this));
        DbSalesController dbSales = new DbSalesController(this);
        sales = dbSales.readSales(getIntent().getExtras().getInt("idUser"));
        ListaSalesAdapter adapter = new ListaSalesAdapter(dbSales.readSales(getIntent().getExtras().getInt("idUser")));
        listaVentas.setAdapter(adapter);
        double saldo=0;
        for(Sale sale:sales){
            saldo+=sale.getTotalPrice();
        }
        DbUsersController dbUsers = new DbUsersController(this);
        String nombre = dbUsers.obtainName(getIntent().getExtras().getInt("idUser"));
        TextView textView = findViewById(R.id.txtNombre);
        TextView textView1 = findViewById(R.id.txtSaldoActual);
        textView.setText(textView.getText()+nombre);
        textView1.setText(textView1.getText()+Double.toString(saldo));

    }

    public void onClickRegistrarVenta(View view) {
        Intent intent = new Intent(UsuarioVendedor.this,RegistrarVenta.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(UsuarioVendedor.this,Usuarios.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }
}