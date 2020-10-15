package com.example.tienbeerv20.Logic;

import com.example.tienbeerv20.Data.Cerveza;

import java.util.ArrayList;

public class SixPackGenerator {
    private ArrayList<Cerveza> seleccion;
    private ArrayList<Cerveza> seleccionClon;
    private ArrayList<Cerveza> seleccionClon2;

    public ArrayList<Cerveza> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(ArrayList<Cerveza> seleccion) {
        this.seleccion = seleccion;
        //clonar la lista al momento de crearla
        setSeleccionClon(seleccion);
        setSeleccionClon2(seleccion);
    }

    public ArrayList<Cerveza> getSeleccionClon() {
        return seleccionClon;
    }

    public void setSeleccionClon(ArrayList<Cerveza> seleccionClon) {
        this.seleccionClon = seleccionClon;
    }

    public ArrayList<Cerveza> getSeleccionClon2() {
        return seleccionClon2;
    }

    public void setSeleccionClon2(ArrayList<Cerveza> seleccionClon2) {
        this.seleccionClon2 = seleccionClon2;
    }

    public void Repetidas(){}

    public void NoRepetidas(){


    }
}
