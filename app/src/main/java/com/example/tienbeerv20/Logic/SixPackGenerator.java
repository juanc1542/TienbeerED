package com.example.tienbeerv20.Logic;

import com.example.tienbeerv20.Data.Cerveza;

import java.util.ArrayList;

public class SixPackGenerator {
    private ArrayList<Cerveza> seleccion;
    private ArrayList<Cerveza> seleccionClon;

    public ArrayList<Cerveza> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(ArrayList<Cerveza> seleccion) {
        this.seleccion = seleccion;
        //clonar la lista al momento de crearla
        setSeleccionClon(seleccion);
    }

    public ArrayList<Cerveza> getSeleccionClon() {
        return seleccionClon;
    }

    public void setSeleccionClon(ArrayList<Cerveza> seleccionClon) {
        this.seleccionClon = seleccionClon;
    }


    public
}
