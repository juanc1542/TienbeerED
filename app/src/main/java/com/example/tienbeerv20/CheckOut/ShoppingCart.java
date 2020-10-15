package com.example.tienbeerv20.CheckOut;

import com.example.tienbeerv20.Data.SixPack;

public class ShoppingCart {

    private long id;
    private int precioTotal;
    SixPack total[] = new SixPack[6];
    int NumberOfSixPack = 0;


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
//------------------------------------------------------------------------------------------------------

    public  void  addSixPackToCart(SixPack New_SixPack){
        total[NumberOfSixPack] = New_SixPack;
        NumberOfSixPack++;
    }
//------------------------------------------------------------------------------------------------------
    public void removeSixPackFromCart(int SixPackRemove){
        int delete = SixPackRemove;

        total[delete] = null;

        for (int i = delete; i<total.length;i++){
            total[i] = total[i+1];
        }

    }
//------------------------------------------------------------------------------------------------------
    public void CheckOut(){
        //Ingreso de los datos para el envío (?)
        new OrderDetails();



    }
//------------------------------------------------------------------------------------------------------
}
