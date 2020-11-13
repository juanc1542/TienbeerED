package com.example.tienbeerv20.ui.BusquedaCervezas;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.R;

public class BusquedaCerveza extends Fragment {

    private BusquedaCervezaViewModel mViewModel;

    public static BusquedaCerveza newInstance() {
        return new BusquedaCerveza();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.busqueda_cerveza_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BusquedaCervezaViewModel.class);
        // TODO: Use the ViewModel
    }

}