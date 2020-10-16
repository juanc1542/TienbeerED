package com.example.tienbeerv20.Logic;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.SixPack;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SixPackGenerator {
    private ArrayList<Cerveza> seleccion;
    private ArrayList<Cerveza> seleccionClon;
    private SixPack sixpack = new SixPack();

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

    /*es el método quedebe recibir la lista de cervezas del primer filtro de firebase
    y el objeto filtro de lo que se halla recibido de input por el usuario en filtros.
    de este método debe definir el arreglo de cervezas y el clon del arreglo y debe enviarle
    al método filtro el segundo filtro para que este llene el six pack. Tras comprobar si el
    sixpack está lleno o no debe regresar el sixpack o enviar el tercer filtro al método filtro
    para llenar el sixpack y finalmente retornarlo
     */

    public SixPack generarSixpack(){
        //traer los filtros del usuario e instanciar filtro con los filtros
        //traer lista de firebase y meterla en selección
        //clonar lista
        //enviar a filter el segundo filtro
        //verificar si el sixpack está lleno
        //si está lleno retornar y si no, clonar la selección y enviar a filter el 3er filtro
        return sixpack;
    }

    //A este metodo le entra el segundo filtro y la preferencia del usuario para este filtro
    //Borra todas las cervezas que no satisfacen la preferencia del usuario
    public void filter(String filtro, String preferencia){
        Iterator<Cerveza> itr = seleccionClon.iterator();
        if (filtro.equals("nacionalidad")){
            while (itr.hasNext()){
                String nacionalidadNext = (String)itr.next().getNacionalidad();
                if(!nacionalidadNext.equals(preferencia)){
                    itr.remove();
                }
            }
        }if (filtro.equals("precio")){
            while (itr.hasNext()){
                String precioNext = (String)itr.next().getRangoPrecio();
                if(!precioNext.equals(preferencia)){
                    itr.remove();
                }
            }
        }if (filtro.equals("tipo")){
            while (itr.hasNext()){
                String tipoNext = (String)itr.next().getTipo();
                if(!tipoNext.equals(preferencia)){
                    itr.remove();
                }
            }
        }if (filtro.equals("alcohol")){
            while (itr.hasNext()){
                String alcoholNext = (String)itr.next().getAlcohol();
                if(!alcoholNext.equals(preferencia)){
                    itr.remove();
                }
            }
        }


    }
}
