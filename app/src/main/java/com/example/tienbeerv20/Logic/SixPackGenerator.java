package com.example.tienbeerv20.Logic;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.Filtro;
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

    public SixPack generarSixpack(Filtro filtro, ArrayList<Cerveza> primerFiltro){
        this.setSeleccion(primerFiltro);
        //enviar a filter el segundo filtro
        int currentP = 1; //variable que determina la posición en la prioridad
        while(!sixpack.lleno()){
            this.filter(filtro.getFiltros()[currentP][0], filtro.getFiltros()[currentP][1]);
            currentP++;
        }
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
                String nacionalidadNext = itr.next().getNacionalidad();
                //comprobar si está ya está en el sixpack
                if(!nacionalidadNext.equals(preferencia) && this.sixpack.contiene(itr.next())){
                    itr.remove();
                }
            }
        }if (filtro.equals("precio")){
            while (itr.hasNext()){
                String precioNext = itr.next().getRangoPrecio();
                if(!precioNext.equals(preferencia) && this.sixpack.contiene(itr.next())){
                    itr.remove();
                }
            }
        }if (filtro.equals("tipo")){
            while (itr.hasNext()){
                String tipoNext = itr.next().getTipo();
                if(!tipoNext.equals(preferencia) && this.sixpack.contiene(itr.next())){
                    itr.remove();
                }
            }
        }if (filtro.equals("alcohol")){
            while (itr.hasNext()){
                String alcoholNext = itr.next().getAlcohol();
                if(!alcoholNext.equals(preferencia) && this.sixpack.contiene(itr.next())){
                    itr.remove();
                }
            }
        }

        //booleano de repetidas temporal mientras se saca de la instanciación del filtro
        boolean repetidas = true;
        if(repetidas){
            while(!sixpack.lleno()){
                //mientras que el sixpack no esté lleno, llena con las cervezas que quedaron del 2do filtro
                sixpack.añadirCerveza(seleccionClon.get((int) Math.floor(Math.random()*seleccionClon.size())));
            }
        }

    }
}
