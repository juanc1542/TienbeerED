package com.example.tienbeerv20.ui.HashMaps;


import com.example.tienbeerv20.Data.Cerveza;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class BusquedaHash {

    HashMap<String, Cerveza> BusquedaMap = new HashMap<>();

    private Cerveza key;

    public Cerveza getKey() {
        return key;
    }

    public void setKey(Cerveza key) {
        this.key = key;
    }


    public void llenar(ArrayList<Cerveza> cerveza){


        for(int i = 0; i<cerveza.size(); i++){
        BusquedaMap.put(cerveza.get(i).getNombre(), cerveza.get(i));
        }
    }

    public Cerveza buscar(String nombre){

        if(BusquedaMap.get(nombre)==null){
            System.out.println("No hay nada we");
            return BusquedaMap.get(nombre);
        }else return BusquedaMap.get(nombre);
    }



}
