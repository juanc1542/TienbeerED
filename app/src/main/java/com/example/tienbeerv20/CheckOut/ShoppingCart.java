package com.example.tienbeerv20.CheckOut;

public class ShoppingCart {

    private long id;
    private int precioTotal;
    //variable array sixpack

    public ShoppingCart(long id, int precioTotal){
        this.id=id;
        this.precioTotal=precioTotal;

    }


    public long getId() {
        return id;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }
}
