package com.example.tienbeerv20.Data;

public class Filtro {

    private String prefNacionalidad;
    private String prefTipo;
    private String prefAlcohol;
    private boolean repetidas;
    private String prefPrecio;
    private String[] prioridad;

    public Filtro(String prefNacionalidad, String prefTipo, String prefAlcohol, boolean repetidas, String prefPrecio, String[] prioridad) {
        this.prefNacionalidad = prefNacionalidad;
        this.prefTipo = prefTipo;
        this.prefAlcohol = prefAlcohol;
        this.repetidas = repetidas;
        this.prefPrecio = prefPrecio;
        this.prioridad = prioridad;
    }

    public String getPrefNacionalidad() {
        return prefNacionalidad;
    }

    public boolean isRepetidas() {return repetidas;}

    public String getPrefTipo() {
        return prefTipo;
    }

    public String getPrefAlcohol() {
        return prefAlcohol;
    }

    public String getPrefPrecio() {
        return prefPrecio;
    }

    public String[] getPrioridad() {
        return prioridad;
    }
}
