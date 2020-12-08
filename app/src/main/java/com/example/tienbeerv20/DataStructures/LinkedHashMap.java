package com.example.tienbeerv20.DataStructures;

import com.example.tienbeerv20.Data.Cerveza;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class LinkedHashMap {

    java.util.LinkedHashMap<String,Cerveza> Link_Map = new java.util.LinkedHashMap<>();




    private Cerveza key;
    public Cerveza getKey() {
        return key;
    }

    public void setKey(Cerveza key) {
        this.key = key;
    }



    public void insert(Cerveza key){
        Link_Map.put(key.getNombre(), key);
    }

    public Cerveza search(String nombre){
    return Link_Map.get(nombre);
    }

    public void remove(String nombre){
        Link_Map.remove(nombre);
    }

    public boolean isEmpty(){

    return Link_Map.size() == 6;
    }

    public int cantidad(){
        int count =0;
        for(int i = 0; i<=Link_Map.size();i++) {
            if (Link_Map.get(i)!=null){
                count++;
            }
        }
        return count;

    }

    public boolean contiene(Cerveza cerveza){
        for(int i=0; i<6;i++){
            if(cerveza.equals(Link_Map.get(i))){
                return true;
            }
        }
        return false;
    }


    public Cerveza[] MapToArray(){

        List<Cerveza> l = new ArrayList<Cerveza>(Link_Map.values());
        Cerveza[] ArrayMap = new Cerveza[6];
        for (int i = 0; i<l.size();i++){
            ArrayMap[i] = (Cerveza) l.get(i);
        }

        return ArrayMap;
    }





}
