package com.example.amu.model;

import java.sql.Date;

public class Sale {
    private int idUser;
    private double totalPrice;
    private String descripcion;
    private Date fecha;

    public Sale(int idUser,double totalPrice,String descripcion){
        this.descripcion = descripcion;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        setFecha();
    }

    public Sale(int idUser,double totalPrice,String descripcion,Date fecha){
        this.descripcion = descripcion;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.fecha = fecha;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha() {
        java.util.Date date = new java.util.Date();
        fecha = new Date(date.getYear()-1900,date.getDay()-1,date.getMonth());
    }
}
