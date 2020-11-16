package com.example.tienbeerv20.ui.SeleccionCervezas;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.Recycler.AdaptadorTres;
import com.example.tienbeerv20.ui.Recycler.AdaptadorUno;

import java.util.ArrayList;

public class SeleccionCervezas extends Fragment {

    private SeleccionCervezasViewModel mViewModel;
    RecyclerView recyclerOP;
    private int precioFin=0;

    public static SeleccionCervezas newInstance() {
        return new SeleccionCervezas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        View v= inflater.inflate(R.layout.fragment_seleccion_cervezas, container, false);

        TextView precio = v.findViewById(R.id.textPrecioFinal);



        ArrayList<Cerveza> cervezasRecibidas= (ArrayList<Cerveza>) getArguments().getSerializable("key");

        recyclerOP = (RecyclerView) v.findViewById(R.id.recyclerSel);
        recyclerOP.setLayoutManager(new LinearLayoutManager(getContext()));

        AdaptadorTres adapter3 = new AdaptadorTres(cervezasRecibidas);
        recyclerOP.setAdapter(adapter3);

        for (int i=0; i<cervezasRecibidas.size();i++){
            int u=0;
            u=cervezasRecibidas.get(i).getPrecio();
            precioFin=precioFin+u;
        }

        precio.setText("$"+precioFin);







        /*
        for(int i=0; i<cervezasRecibidas.size();i++){
            System.out.println(cervezasRecibidas.get(i));
        }



        cer1.setText(cervezasRecibidas.get(0));
        cer2.setText(cervezasRecibidas.get(1));
        cer3.setText((cervezasRecibidas.get(2)));
        if(cervezasRecibidas.size()>3){
            cer4.setText(cervezasRecibidas.get(3));
            cer5.setText(cervezasRecibidas.get(4));
            cer6.setText(cervezasRecibidas.get(5));
        }
*/
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SeleccionCervezasViewModel.class);
        // TODO: Use the ViewModel


    }



}