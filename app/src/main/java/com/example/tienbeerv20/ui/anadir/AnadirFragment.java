package com.example.tienbeerv20.ui.anadir;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienbeerv20.R;
//import com.example.tienbeerv20.ui.R;

public class AnadirFragment extends Fragment {

    private AnadirViewModel mViewModel;

    public static AnadirFragment newInstance() {
        return new AnadirFragment();
    }

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

}