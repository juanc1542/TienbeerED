package com.example.tienbeerv20.ui.SeleccionCervezas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.R;

public class SeleccionCervezas extends Fragment {

    private SeleccionCervezasViewModel mViewModel;

    public static SeleccionCervezas newInstance() {
        return new SeleccionCervezas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seleccion_cervezas, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SeleccionCervezasViewModel.class);
        // TODO: Use the ViewModel
    }

}