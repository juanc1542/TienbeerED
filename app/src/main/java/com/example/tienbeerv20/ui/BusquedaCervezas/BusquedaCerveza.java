package com.example.tienbeerv20.ui.BusquedaCervezas;

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
import android.widget.SearchView;

import com.example.tienbeerv20.R;

public class BusquedaCerveza extends Fragment implements SearchView.OnQueryTextListener {

    private BusquedaCervezaViewModel mViewModel;
    private RecyclerView rvLista;
    private SearchView svSearch;

    public static BusquedaCerveza newInstance() {
        return new BusquedaCerveza();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.busqueda_cerveza_fragment, container, false);
    }
    private void initViews(){
        svSearch= svSearch.findViewById(R.id.searchViewBar);
        rvLista= rvLista.findViewById(R.id.rvMain);

    }

    private void initValues(){
        LinearLayoutManager manager= new LinearLayoutManager(getActivity());
        rvLista.setLayoutManager(manager);

        //items
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BusquedaCervezaViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}