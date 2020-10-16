package com.example.tienbeerv20.Data;

public class SixPack {
    public Cerveza[] sixpack= new Cerveza[6];
    int head=0;

    public void añadirCerveza(Cerveza cerveza){
        if(!this.lleno()){
            sixpack[head]=cerveza;
            head++;
        }
    }

    public boolean vacio(){
        return head==0;
    }

    public void removerCerveza(){

    }

    public boolean lleno(){
        return head == 7;
    }
}
