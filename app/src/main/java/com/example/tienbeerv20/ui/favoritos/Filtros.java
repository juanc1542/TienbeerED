package com.example.tienbeerv20.ui.favoritos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.filtros.FiltrosViewModel;

public class Filtros extends Fragment {

    private FiltrosViewModel mViewModel;

    public static Filtros newInstance() {
        return new Filtros();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.filtros_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FiltrosViewModel.class);
        // TODO: Use the ViewModel
    }



}