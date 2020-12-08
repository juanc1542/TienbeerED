package com.example.tienbeerv20.Logic;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.Filtro;
import com.example.tienbeerv20.Data.SixPack;
import com.example.tienbeerv20.DataStructures.LinkedHashMap;
import com.google.common.base.Stopwatch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class SixPackGenerator {
    private ArrayList<Cerveza> seleccion;
    private ArrayList<Cerveza> seleccionClon;

    private LinkedHashMap Six_Map = new LinkedHashMap();
    private SixPack sixpack = new SixPack();
    private String caso;
    private boolean repetidas;



    public ArrayList<Cerveza> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(ArrayList<Cerveza> seleccion) {
        this.seleccion = seleccion;
    }

    public ArrayList<Cerveza> getSeleccionClon() {
        return seleccionClon;
    }

    public void setSeleccionClon(ArrayList<Cerveza> seleccionClon) {
        this.seleccionClon = seleccionClon;
    }

    /*es el método quedebe recibir la lista de cervezas del primer filtro de firebase
    y el objeto filtro de lo que se halla recibido de input por el usuario en filtros.
    de este método debe definir el arreglo de cervezas y el clon del arreglo y debe enviarle
    al método filtro el segundo filtro para que este llene el six pack. Tras comprobar si el
    sixpack está lleno o no debe regresar el sixpack o enviar el tercer filtro al método filtro
    para llenar el sixpack y finalmente retornarlo
     */

    public static void añadirCerveza(Cerveza cerveza, /*SixPack sixpack*/ LinkedHashMap Six_Map){

        /*if(!sixpack.lleno()){
            sixpack.añadirCerveza(cerveza);
        }

         */

        if(!Six_Map.isEmpty()){
            Six_Map.insert(cerveza);
        }
    }

    /*public SixPack generarSixpack(Filtro filtro, ArrayList<Cerveza> primerFiltro, String caso){
        this.caso=caso;
        this.repetidas=filtro.getRepetidas();
        this.setSeleccion(primerFiltro);
        //enviar a filter el segundo filtro
        int currentP = 1; //variable que determina la posición en la prioridad
        //verificar si el sixpack está lleno
        //si está lleno retornar y si no, clonar la selección y enviar a filter el 3er filtro
        //realiza una acción dependiendo de si

        switch (caso){
            //caso de aleatorio hasta llenar
            case "r":
                while(!sixpack.lleno() && currentP<4){
                    this.setSeleccionClon(seleccion);
                    this.filter(filtro.getFiltros()[currentP][0], filtro.getFiltros()[currentP][1]);
                    currentP++;
                }
                //En caso de que haya pocas cervezas
                if(sixpack.lleno()){
                    break;
                }else{
                    while(!sixpack.lleno()){
                        sixpack.añadirCerveza(seleccion.get((int) Math.floor(Math.random()*seleccion.size())));
                    }
                    break;
                }
            //caso hasta llenar 3
            case "a":
                while(sixpack.cantidad()<3 && currentP<4){
                    this.setSeleccionClon(seleccion);
                    this.filter(filtro.getFiltros()[currentP][0], filtro.getFiltros()[currentP][1]);
                    currentP++;
                }

                if(sixpack.cantidad()==3){
                    break;
                }else{
                    while(sixpack.cantidad()<3){
                        sixpack.añadirCerveza(seleccion.get((int) Math.floor(Math.random()*seleccion.size())));
                    }
                    break;
                }
        }



        return Six_Map; //regresa a la clase de UI filtros el sixpack
    }*/


    public LinkedHashMap generarSixpack(Filtro filtro, ArrayList<Cerveza> primerFiltro, String caso){
        this.caso=caso;
        this.repetidas=filtro.getRepetidas();
        this.setSeleccion(primerFiltro);
        //enviar a filter el segundo filtro
        int currentP = 1; //variable que determina la posición en la prioridad
        //verificar si el sixpack está lleno
        //si está lleno retornar y si no, clonar la selección y enviar a filter el 3er filtro
        //realiza una acción dependiendo de si

        //------------------------------------------------------------------------------------------


        switch (caso){


            //caso de aleatorio hasta llenar
            case "r":
                while(!Six_Map.isEmpty() && currentP<4){
                    this.setSeleccionClon(seleccion);
                    this.filter(filtro.getFiltros()[currentP][0], filtro.getFiltros()[currentP][1]);
                    currentP++;
                }
                //En caso de que haya pocas cervezas
                if(Six_Map.isEmpty()){
                    break;
                }else{
                    while(!Six_Map.isEmpty()){
                        Six_Map.insert(seleccion.get((int) Math.floor(Math.random()*seleccion.size())));
                    }
                    break;
                }
                //caso hasta llenar 3
            case "a":
                while(Six_Map.cantidad()<3 && currentP<4){
                    this.setSeleccionClon(seleccion);
                    this.filter(filtro.getFiltros()[currentP][0], filtro.getFiltros()[currentP][1]);
                    currentP++;
                }

                if(Six_Map.cantidad()==3){
                    break;
                }else{
                    while(Six_Map.cantidad()<3){
                        Six_Map.insert(seleccion.get((int) Math.floor(Math.random()*seleccion.size())));
                    }
                    break;
                }
        }


        //------------------------------------------------------------------------------------------

        return Six_Map; //regresa a la clase de UI filtros el sixpack
    }

    //A este metodo le entra el segundo filtro y la preferencia del usuario para este filtro
    //Borra todas las cervezas que no satisfacen la preferencia del usuario



    /*public void filter(String filtro, String preferencia){
        Iterator<Cerveza> itr = seleccionClon.iterator();
        if (filtro.equals("Nacionalidad")){
            while (itr.hasNext()){
                String nacionalidadNext = itr.next().getNacionalidad();
                //comprobar si está ya está en el sixpack
                if(!nacionalidadNext.equals(preferencia) || this.sixpack.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Precio")){
            while (itr.hasNext()){
                String precioNext = itr.next().getRangoPrecio();
                if(!precioNext.equals(preferencia) || this.sixpack.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Tipo")){
            while (itr.hasNext()){
                String tipoNext = itr.next().getTipo();
                if(!tipoNext.equals(preferencia) || this.sixpack.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Alcohol")) {
            while (itr.hasNext()) {
                String alcoholNext = itr.next().getAlcohol();
                if (!alcoholNext.equals(preferencia) || this.sixpack.contiene(itr.next()) || itr.next().getCantidad() == 0) {
                    itr.remove();
                }
            }
        }

        if(repetidas){
            switch(caso){
                case "r":
                    while(!sixpack.lleno()){
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        sixpack.añadirCerveza(seleccionClon.get((int) Math.floor(Math.random()*seleccionClon.size())));
                    }
                    break;
                case "a":
                    while(sixpack.cantidad()<3){
                        //mientras que el sixpack no tenga 3, llena con las cervezas que quedaron del 2do filtro
                        sixpack.añadirCerveza(seleccionClon.get((int) Math.floor(Math.random()*seleccionClon.size())));
                    }
                    break;
            }
        }else{
            switch(caso) {
                case "r":
                    while (!sixpack.lleno() && !seleccionClon.isEmpty()) {
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        int index=(int) Math.floor(Math.random()*(seleccionClon.size()-1));
                        sixpack.añadirCerveza(seleccionClon.get(index));
                        seleccionClon.remove(index);
                    }
                    break;
                case "a":
                    while (sixpack.cantidad() < 3 && !seleccionClon.isEmpty()) {
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        int index=(int) Math.floor(Math.random()*(seleccionClon.size()-1));
                        sixpack.añadirCerveza(seleccionClon.get(index));
                        seleccionClon.remove(index);
                    }
                    break;
            }
        }

    }*/

    public void filter(String filtro, String preferencia){

        Stopwatch filter = Stopwatch.createStarted();


        Iterator<Cerveza> itr = seleccionClon.iterator();
        if (filtro.equals("Nacionalidad")){
            while (itr.hasNext()){
                String nacionalidadNext = itr.next().getNacionalidad();
                //comprobar si está ya está en el sixpack
                if(!nacionalidadNext.equals(preferencia) || this.Six_Map.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Precio")){
            while (itr.hasNext()){
                String precioNext = itr.next().getRangoPrecio();
                if(!precioNext.equals(preferencia) || this.Six_Map.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Tipo")){
            while (itr.hasNext()){
                String tipoNext = itr.next().getTipo();
                if(!tipoNext.equals(preferencia) || this.Six_Map.contiene(itr.next()) || itr.next().getCantidad() == 0){
                    itr.remove();
                }
            }
        }if (filtro.equals("Alcohol")) {
            while (itr.hasNext()) {
                String alcoholNext = itr.next().getAlcohol();
                if (!alcoholNext.equals(preferencia) || this.Six_Map.contiene(itr.next()) || itr.next().getCantidad() == 0) {
                    itr.remove();
                }
            }
        }

        if(repetidas){
            switch(caso){
                case "r":
                    while(!Six_Map.isEmpty()){
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        Six_Map.insert(seleccionClon.get((int) Math.floor(Math.random()*seleccionClon.size())));
                    }
                    break;
                case "a":
                    while(Six_Map.cantidad()<3){
                        //mientras que el sixpack no tenga 3, llena con las cervezas que quedaron del 2do filtro
                        Six_Map.insert(seleccionClon.get((int) Math.floor(Math.random()*seleccionClon.size())));

                    }
                    break;
            }
        }else{
            switch(caso) {
                case "r":
                    while (!Six_Map.isEmpty() && !seleccionClon.isEmpty()) {
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        int index=(int) Math.floor(Math.random()*(seleccionClon.size()-1));
                        Six_Map.insert(seleccionClon.get(index));
                        seleccionClon.remove(index);
                    }
                    break;
                case "a":
                    while (Six_Map.cantidad() < 3 && !seleccionClon.isEmpty()) {
                        //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                        int index=(int) Math.floor(Math.random()*(seleccionClon.size()-1));
                        Six_Map.insert(seleccionClon.get(index));
                        seleccionClon.remove(index);
                    }
                    break;
            }
        }


        filter.stop();
        System.out.println("Elapsed time in Nanoseconds for Filtro 1() ==> " + filter.elapsed(TimeUnit.NANOSECONDS));
    }




}
