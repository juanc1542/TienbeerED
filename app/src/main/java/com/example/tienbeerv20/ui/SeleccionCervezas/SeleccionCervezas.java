package com.example.tienbeerv20.ui.SeleccionCervezas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;

import java.util.ArrayList;

public class SeleccionCervezas extends Fragment {

    private SeleccionCervezasViewModel mViewModel;

    public static SeleccionCervezas newInstance() {
        return new SeleccionCervezas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_seleccion_cervezas, container, false);

        TextView cer1 = v.findViewById(R.id.cerveza1);
        TextView cer2 = v.findViewById(R.id.cerveza2);
        TextView cer3 = v.findViewById(R.id.cerveza3);
        TextView cer4 = v.findViewById(R.id.cerveza4);
        TextView cer5 = v.findViewById(R.id.cerveza5);
        TextView cer6 = v.findViewById(R.id.cerveza6);

        ArrayList<Cerveza> cervezasRecibidas= (ArrayList<Cerveza>) getArguments().getSerializable("key");

        //Impresion de las cervezas provisionalmente
        cer1.setText(cervezasRecibidas.get(0).getNombre() + " " + cervezasRecibidas.get(0).getNacionalidad() + " " + cervezasRecibidas.get(0).getRangoPrecio());
        cer2.setText(cervezasRecibidas.get(1).getNombre() + " " + cervezasRecibidas.get(1).getNacionalidad() + " " + cervezasRecibidas.get(1).getRangoPrecio());
        cer3.setText(cervezasRecibidas.get(2).getNombre() + " " + cervezasRecibidas.get(2).getNacionalidad() + " " + cervezasRecibidas.get(2).getRangoPrecio());
        if(cervezasRecibidas.size()>3){
        cer4.setText(cervezasRecibidas.get(3).getNombre() + " " + cervezasRecibidas.get(3).getNacionalidad() + " " + cervezasRecibidas.get(3).getRangoPrecio());
        cer5.setText(cervezasRecibidas.get(4).getNombre() + " " + cervezasRecibidas.get(4).getNacionalidad() + " " + cervezasRecibidas.get(4).getRangoPrecio());
        cer6.setText(cervezasRecibidas.get(5).getNombre() + " " + cervezasRecibidas.get(5).getNacionalidad() + " " + cervezasRecibidas.get(5).getRangoPrecio());
        }





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