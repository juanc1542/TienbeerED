package com.example.tienbeerv20.ui.Busqueda;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.Recycler.AdaptadorUno;

import java.util.ArrayList;

public class Busqueda extends Fragment {

    RecyclerView recyclerOP;
    private ArrayList<Cerveza> ops = new ArrayList<Cerveza>();

    private BusquedaViewModel mViewModel;
    String seleccionBoton;

    public static Busqueda newInstance() {
        return new Busqueda();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.busqueda_fragment, container, false);

        recyclerOP = (RecyclerView) v.findViewById(R.id.rvBusqueda);
        recyclerOP.setLayoutManager(new LinearLayoutManager(getContext()));

        seleccionBoton= getArguments().getString("llave");

        displayCervezas(v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BusquedaViewModel.class);
        // TODO: Use the ViewModel
    }

    public void displayCervezas(View view){

        Cerveza beer = new Cerveza("Poker","Colombiana",3000,"$$","Lager","Mas de 8",10);
        Cerveza beer2 = new Cerveza("Aguila","Colombiana",3000,"$$","Lager","Mas de 8",10);

        ops.add(beer);
        ops.add(beer2);
        AdaptadorUno adapter= new AdaptadorUno(ops);
        recyclerOP.setAdapter(adapter);
    }

}