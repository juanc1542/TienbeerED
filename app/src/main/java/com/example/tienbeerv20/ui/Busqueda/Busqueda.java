package com.example.tienbeerv20.ui.Busqueda;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.Tests;
import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.Recycler.AdaptadorDos;
import com.example.tienbeerv20.ui.Recycler.AdaptadorUno;

import java.util.ArrayList;

public class Busqueda extends Fragment implements View.OnClickListener{

    RecyclerView recyclerOP;
    private ArrayList<Cerveza> ops = new ArrayList<Cerveza>();

    private BusquedaViewModel mViewModel;
    String seleccionBoton;

    private Button botonBuscar;

    private EditText editTextBusqueda;

    public static Busqueda newInstance() {
        return new Busqueda();
    }

    private String stringTextBusqueda;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.busqueda_fragment, container, false);

        recyclerOP = (RecyclerView) v.findViewById(R.id.rvBusqueda);
        recyclerOP.setLayoutManager(new LinearLayoutManager(getContext()));
        seleccionBoton= getArguments().getString("llave");
        System.out.println(seleccionBoton);
        displayCervezas(v);
        botonBuscar = (Button) v.findViewById(R.id.botonBuscar);
        editTextBusqueda =  (EditText) v.findViewById(R.id.editTextBusqueda);
        return v;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(BusquedaViewModel.class);
//        // TODO: Use the ViewModel
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.botonBuscar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==botonBuscar.getId()){
            stringTextBusqueda = editTextBusqueda.getText().toString();
            Toast.makeText(getActivity(), stringTextBusqueda, Toast.LENGTH_LONG).show();
        }
    }


    public void displayCervezas(View view){
        Cerveza beer = new Cerveza("Poker", "Colombiana", 3000, "$$", "Lager", "Mas de 8", 10);
        Cerveza beer2 = new Cerveza("Aguila", "Colombiana", 3000, "$$", "Lager", "Mas de 8", 10);

        ops.add(beer);
        ops.add(beer2);

        if(seleccionBoton.equals("GeneracionManual")){
            AdaptadorUno adapter1 = new AdaptadorUno(ops);
            recyclerOP.setAdapter(adapter1);
        } else if (seleccionBoton.equals("GeneracionAMedias")){
            AdaptadorDos adapter2 = new AdaptadorDos(ops);
            recyclerOP.setAdapter(adapter2);
        }
    }

}