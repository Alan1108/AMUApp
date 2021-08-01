package com.example.amu.model;

public class Shop {
    private int idShop;
    private int idUser;
    private double total;

    public Shop(int idUser, double total) {
        this.idUser = idUser;
        this.total = total;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
