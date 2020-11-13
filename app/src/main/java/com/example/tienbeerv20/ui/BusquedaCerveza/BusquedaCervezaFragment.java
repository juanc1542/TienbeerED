package com.example.tienbeerv20.ui.BusquedaCerveza;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.R;
//import com.example.tienbeerv20.ui.BusquedaCerveza.R;

public class BusquedaCervezaFragment extends Fragment {

    private BusquedaCervezaModel mViewModel;

    public static BusquedaCervezaFragment newInstance() {
        return new BusquedaCervezaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.busqueda_cerveza, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BusquedaCervezaModel.class);
        // TODO: Use the ViewModel
    }

}