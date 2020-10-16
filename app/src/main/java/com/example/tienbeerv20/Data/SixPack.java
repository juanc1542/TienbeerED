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

    public boolean contiene(Cerveza cerveza){
        for(int i=0; i<6;i++){
            if(cerveza.equals(sixpack[i])){
                return true;
            }
        }
        return false;
    }

    public int cantidad(){
        return head;
    }

    public boolean vacio(){
        return head==0;
    }

    //remueve una cerveza específica
    public void removerCerveza(Cerveza cerveza){

    }

    public boolean lleno(){
        return head == 6;
    }
}
