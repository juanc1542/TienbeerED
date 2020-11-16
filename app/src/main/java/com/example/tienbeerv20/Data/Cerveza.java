package com.example.tienbeerv20.Data;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Cerveza {

    private String nombre;
    private String nacionalidad;
    private int precio;
    private String rangoPrecio;
    private String tipo;
    private String alcohol;
    private int Cantidad;

    public Cerveza(){}
    //Metodo constructor
    public Cerveza(String Nombre,String Nacionalidad,int Precio,String rangoPrecio, String Tipo, String Alcohol,int Cantidad){
        this.nombre= Nombre;
        this.nacionalidad= Nacionalidad;
        this.precio= Precio;
        this.rangoPrecio=rangoPrecio;
        this.tipo= Tipo;
        this.alcohol= Alcohol;
        this.Cantidad=Cantidad;
    }

    //Metodo para subir el arreglo de informacion a la base de datos
    public void subirCervezas(DatabaseReference mDatabase1){
        String id = mDatabase1.child("Cervezas").push().getKey();
        mDatabase1.child("Cervezas").child(id).setValue(this);
    }



    //Getters de los atributos
    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getRangoPrecio() {
        return rangoPrecio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAlcohol() {
        return alcohol;
    }

    //Setters de los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setRangoPrecio(String rangoPrecio) {
        this.rangoPrecio = rangoPrecio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }
    public int getCantidad() {return Cantidad;}
    public void setCantidad(int Cantidad){ this.Cantidad = Cantidad;}
}
