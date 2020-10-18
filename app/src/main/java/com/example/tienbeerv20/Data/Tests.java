package com.example.tienbeerv20.Data;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tests {
    String[] arrayNac = {"Alemana", "Francesa", "Colombiana","Americana","Belga","Mexicana","Española","Japonesa","Resto del mundo"};
    String[] arrayTipo = {"De Trigo", "Porter/Stout", "Lambic","Lager","Otras"};
    String[] arrayPrecio = {"Economica","Intermedia","Cara"};
    String[] arrayAlcohol = {"Sin Alcohol", "Menor a 4.5%", "Entre 4.5% y 8%", "Mayor a 8%"};
    Boolean[] arrayRepetidas = {true, false};


    public ArrayList<Cerveza> generateTestBeers(int n){
        ArrayList<Cerveza> cervezas = new ArrayList<>();
        int precio = 0;
        for (int i = 1; i <= n; i++){
            String nombre = Integer.toString(i);
            Random rand = new Random();
            int nacIndex = rand.nextInt(arrayNac.length);
            int tipoIndex = rand.nextInt(arrayTipo.length);
            int precioIndex = rand.nextInt(arrayPrecio.length);
            int alcoholIndex = rand.nextInt(arrayAlcohol.length);
            int repetidasIndex = rand.nextInt(arrayRepetidas.length);

            if (precioIndex == 0){
                precio = 1000;
            }else if(precioIndex == 1){
                precio = 6000;
            }else if (precioIndex == 2){
                precio = 11000;
            }

            Cerveza cerveza = new Cerveza(nombre, arrayNac[nacIndex], precio, arrayPrecio[precioIndex], arrayTipo[tipoIndex], arrayAlcohol[alcoholIndex]);
            cervezas.add(cerveza);
        }
        return cervezas;
    }
}
