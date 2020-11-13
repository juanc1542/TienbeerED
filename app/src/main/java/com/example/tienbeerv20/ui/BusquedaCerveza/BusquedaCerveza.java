package com.example.tienbeerv20.ui.BusquedaCerveza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tienbeerv20.R;

public class BusquedaCerveza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_cerveza_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BusquedaCervezaFragment.newInstance())
                    .commitNow();
        }
    }
}