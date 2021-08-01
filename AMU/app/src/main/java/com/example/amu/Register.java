package com.example.amu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amu.db.DbUsersController;
import com.example.amu.model.Person;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText name = findViewById(R.id.txtName);
        EditText lastName = findViewById(R.id.txtLastName);
        EditText user = findViewById(R.id.txtUser);
        EditText email = findViewById(R.id.txtEmail);
    }

    public void onClickCancel(View view){
        Intent intent = new Intent(Register.this,MainActivity.class);
        startActivity(intent);
    }
    public void onClickRegister(View view){
        EditText password1 = findViewById(R.id.txtPasswordRegister);
        EditText password2 = findViewById(R.id.txtPasswordRegister2);
        EditText name = findViewById(R.id.txtName);
        EditText lastName = findViewById(R.id.txtLastName);
        EditText user = findViewById(R.id.txtUser);
        EditText email = findViewById(R.id.txtEmailRegister);
        boolean bandera = true;
        if(name.getText().toString().equals("")){
            mostrarDialogo("Ningun campo debe estar vacio!");
            bandera=false;
        }else if(lastName.getText().toString().equals("")){
            mostrarDialogo("Ningun campo debe estar vacio!");
            bandera=false;
        }else if(user.getText().toString().equals("")){
            mostrarDialogo("Ningun campo debe estar vacio!");
            bandera=false;
        }else if(email.getText().toString().equals("")){
            mostrarDialogo("Ningun campo debe estar vacio!");
            bandera=false;
        }else if(password1.getText().toString().equals("") || password2.getText().toString().equals("")
                && password1.getText().toString().equals(password2.getText().toString())){
            mostrarDialogo("Las contraseñas son diferentes o se encuentran vacias!");
            password1.setText("");
            password2.setText("");
            bandera=false;
        }
        DbUsersController dbUsersController = new DbUsersController(Register.this);
        long id = dbUsersController.insertUser(new Person(name.getText().toString(),lastName.getText().toString(),
                email.getText().toString(),user.getText().toString(),password1.getText().toString()));
        if(bandera && id>0){
            mostrarDialogo("REGISTRO INGRESADO CORRECTAMENTE");
            Intent intent = new Intent(Register.this,MainActivity.class);
            startActivity(intent);
        }else{
            mostrarDialogo("ERROR AL REGISTRAR");
            name.setText("");
            lastName.setText("");
            user.setText("");
            email.setText("");
            password1.setText("");
            password2.setText("");
        }


    }

    public void mostrarDialogo(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}