package com.example.tienbeerv20.ui.anadir;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;
import com.google.firebase.database.DatabaseReference;
//import com.example.tienbeerv20.ui.R;

public class AnadirFragment extends Fragment {

    private AnadirViewModel mViewModel;
    DatabaseReference mDatabase;

    public static AnadirFragment newInstance() {
        return new AnadirFragment();
    }

    //Metodos implementados por defecto en la creacion del Fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anadir, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnadirViewModel.class);
        // TODO: Use the ViewModel
    }

    //Metodo de recogida de recogida y subida de informacion a la DB
    /*
    public void  recogerDatos() {
        //Recoleccion de informacion en el xml del fragment

        String name = TextNombre.getText().toString().trim();
        String nacionalidad = TextDescripcion.getText().toString().trim();
        String precio = TextNum.getText().toString().trim();
        String tipo=spiPrecio.getSelectedItem().toString();
        String alcohol=spiServ.getSelectedItem().toString();

        //Setting all the information collected
        Cerveza newBeer = new Cerveza(name,nacionalidad,precio,tipo,alcohol);
        newBeer.setNombre(name);
        newBeer.setNacionalidad(nacionalidad);
        newBeer.setPrecio(precio);
        newBeer.setTipo(tipo);
        newBeer.setAlcohol(alcohol);

        newBeer.subirCervezas(mDatabase);
    }

*/



}