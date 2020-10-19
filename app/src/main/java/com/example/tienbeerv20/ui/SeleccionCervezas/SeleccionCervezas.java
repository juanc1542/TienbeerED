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

        ArrayList<String> cervezasRecibidas= getArguments().getStringArrayList("key");

        System.out.println(cervezasRecibidas.get(0));
        System.out.println(cervezasRecibidas.get(1));
        System.out.println(cervezasRecibidas.get(2));
        System.out.println(cervezasRecibidas.get(3));
        System.out.println(cervezasRecibidas.get(4));
        System.out.println(cervezasRecibidas.get(5));

        TextView cer1 = v.findViewById(R.id.cerveza1);
        TextView cer2 = v.findViewById(R.id.cerveza2);
        TextView cer3 = v.findViewById(R.id.cerveza3);
        TextView cer4 = v.findViewById(R.id.cerveza4);
        TextView cer5 = v.findViewById(R.id.cerveza5);
        TextView cer6 = v.findViewById(R.id.cerveza6);

        cer1.setText(cervezasRecibidas.get(0));
        cer2.setText(cervezasRecibidas.get(1));
        cer3.setText((cervezasRecibidas.get(2)));
        cer4.setText(cervezasRecibidas.get(3));
        cer5.setText(cervezasRecibidas.get(4));
        cer6.setText(cervezasRecibidas.get(5));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SeleccionCervezasViewModel.class);
        // TODO: Use the ViewModel


    }



}