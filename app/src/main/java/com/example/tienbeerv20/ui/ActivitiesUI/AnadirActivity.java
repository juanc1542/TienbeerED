package com.example.tienbeerv20.ui.ActivitiesUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.anadir.AnadirFragment;

public class AnadirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.anadir_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AnadirFragment.newInstance())
                    .commitNow();
        }
    }
}