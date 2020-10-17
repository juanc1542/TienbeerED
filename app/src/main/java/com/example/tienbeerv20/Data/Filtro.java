package com.example.tienbeerv20.Data;

import java.lang.reflect.Array;

public class Filtro {

    private boolean repetidas;
    private String[][] filtros;

    public Filtro(String[][] filtros, boolean repetidas) {
        this.filtros=filtros;
        this.repetidas=repetidas;
    }

    public String[][] getFiltros() {
        return filtros;
    }

    public boolean getRepetidas() {
        return repetidas;
    }

    public void setFiltros(String[][] filtros) {
        this.filtros = filtros;
    }
}
