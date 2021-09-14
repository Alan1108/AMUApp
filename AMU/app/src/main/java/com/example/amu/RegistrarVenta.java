package com.example.amu;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amu.db.DbSalesController;
import com.example.amu.db.DbUsersController;
import com.example.amu.model.Sale;

import java.util.ArrayList;

public class RegistrarVenta extends AppCompatActivity {
    EditText txtPrice1;
    EditText txtPrice2;
    EditText txtPrice3;
    EditText txtPrice4;
    EditText txtPrice5;
    TextView txtValue;
    ArrayList<Sale> sales = new ArrayList<>();
    double precio=0.0f;
    float auxPrecio;

    public void onClickRetiro(View view) {
        DbSalesController dbSalesController = new DbSalesController(RegistrarVenta.this);
        for(Sale sale:sales){
            long id = dbSalesController.insertSale(sale);
        }
        Intent intent = new Intent(RegistrarVenta.this,PantallaRetiro.class);
        intent.putExtra("idUser",getIntent().getExtras().getInt("idUser"));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_venta);
        DbUsersController dbUsers = new DbUsersController(this);
        String nombre = dbUsers.obtainNameEnterprise(getIntent().getExtras().getInt("idUser"));
        TextView textView = findViewById(R.id.txtNombre2);
        textView.setText(textView.getText()+nombre);
        txtPrice1 = (EditText)findViewById(R.id.txtPrice1);
        txtPrice2 = (EditText)findViewById(R.id.txtPrice2);
        txtPrice3 = (EditText)findViewById(R.id.txtPrice3);
        txtPrice4 = (EditText)findViewById(R.id.txtPrice4);
        txtPrice5 = (EditText)findViewById(R.id.txtPrice5);
        txtValue = (TextView) findViewById(R.id.textView15);
        txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
        txtPrice1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if ((actionId & EditorInfo.IME_ACTION_NEXT) != 0) {
                    precio=Double.parseDouble(txtPrice1.getText().toString().replace(",","."));
                    txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
                    EditText aux = (EditText)findViewById(R.id.editTxtDetail1);
                    if(aux.getText().toString().equals("")){
                        mostrarDialogo("No se puede registrar este item porque el campo de detalle esta vacio!");
                    }else{
                        Sale sale = new Sale(getIntent().getExtras().getInt("idUser"),precio,aux.getText().toString());
                        sales.add(sale);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        txtPrice2.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_ACTION_NEXT) != 0) {
                    precio+=Double.parseDouble(txtPrice2.getText().toString().replace(",","."));
                    txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
                    EditText aux = (EditText)findViewById(R.id.editTxtDetail2);
                    if(aux.getText().toString().equals("")){
                        mostrarDialogo("No se puede registrar este item porque el campo de detalle esta vacio!");
                    }else{
                        Sale sale = new Sale(getIntent().getExtras().getInt("idUser"),precio,aux.getText().toString());
                        sales.add(sale);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        txtPrice3.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_ACTION_NEXT) != 0) {
                    precio+=Double.parseDouble(txtPrice3.getText().toString().replace(",","."));
                    txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
                    EditText aux = (EditText)findViewById(R.id.editTxtDetail3);
                    if(aux.getText().toString().equals("")){
                        mostrarDialogo("No se puede registrar este item porque el campo de detalle esta vacio!");
                    }else{
                        Sale sale = new Sale(getIntent().getExtras().getInt("idUser"),precio,aux.getText().toString());
                        sales.add(sale);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        txtPrice4.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_ACTION_NEXT) != 0) {
                    precio=Double.parseDouble(txtPrice4.getText().toString().replace(",","."));
                    txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
                    EditText aux = (EditText)findViewById(R.id.editTxtDetail4);
                    if(aux.getText().toString().equals("")){
                        mostrarDialogo("No se puede registrar este item porque el campo de detalle esta vacio!");
                    }else{
                        Sale sale = new Sale(getIntent().getExtras().getInt("idUser"),precio,aux.getText().toString());
                        sales.add(sale);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        txtPrice5.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_ACTION_DONE) != 0) {
                    precio+=Double.parseDouble(txtPrice5.getText().toString().replace(",","."));
                    txtValue.setText("Valor a Cobrar: " + Double.toString(precio));
                    EditText aux = (EditText)findViewById(R.id.editTxtDetail5);
                    if(aux.getText().toString().equals("")){
                        mostrarDialogo("No se puede registrar este item porque el campo de detalle esta vacio!");
                    }else{
                        Sale sale = new Sale(getIntent().getExtras().getInt("idUser"),precio,aux.getText().toString());
                        sales.add(sale);
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
        });


    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(RegistrarVenta.this,UsuarioVendedor.class);
        startActivity(intent);
    }

    public void mostrarDialogo(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}