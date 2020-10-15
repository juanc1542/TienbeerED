package com.example.tienbeerv20.Data;

import com.google.firebase.database.DatabaseReference;

public class Cerveza {

    private String nombre;
    private String nacionalidad;
    private String precio;
    private String tipo;
    private String alcohol;

    //Metodo constructor
    public Cerveza(String Nombre,String Nacionalidad,String Precio, String Tipo, String Alcohol){
        this.nombre= Nombre;
        this.nacionalidad= Nacionalidad;
        this.precio= Precio;
        this.tipo= Tipo;
        this.alcohol= Alcohol;
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

    public String getPrecio() {
        return precio;
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

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }
}
