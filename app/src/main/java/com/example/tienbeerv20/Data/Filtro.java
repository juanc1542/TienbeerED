package com.example.tienbeerv20.Data;

import java.lang.reflect.Array;

public class Filtro {

    private boolean repetidas;
    private String[][] filtros = new String[4][2];

    public Filtro(String nacionalidad, String tipo, String alcohol, String precio, int[] prioridad, boolean repetidas) {
        filtros[prioridad[0]][1]= nacionalidad;
        filtros[prioridad[0]][0]= "nacionalidad";
        filtros[prioridad[1]][1]= tipo;
        filtros[prioridad[1]][0]= "tipo";
        filtros[prioridad[2]][1]= alcohol;
        filtros[prioridad[2]][0]= "alcohol";
        filtros[prioridad[3]][1]= precio;
        filtros[prioridad[3]][0]= "precio";
        this.repetidas=repetidas;
    }

    public String[][] getFiltros() {
        return filtros;
    }

    public void setFiltros(String[][] filtros) {
        this.filtros = filtros;
    }
}
