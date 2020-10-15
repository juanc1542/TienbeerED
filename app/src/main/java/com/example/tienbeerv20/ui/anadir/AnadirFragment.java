package com.example.tienbeerv20.ui.anadir;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.example.tienbeerv20.ui.R;

public class AnadirFragment extends Fragment {

    private AnadirViewModel mViewModel;
    DatabaseReference mDatabase;
    private Spinner spiNacionalidad,spiPrecio,spiTipo,spiAlcohol;
    private EditText TextNombre, TextPrecio;
    private Button SUBIR;

    public static AnadirFragment newInstance() {
        return new AnadirFragment();
    }

    //Metodos implementados por defecto en la creacion del Fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_anadir, container, false);

        //Conexion con la base de datos
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Asociacion de objetos en el fragment
        TextNombre = (EditText) view.findViewById(R.id.ANtextoName);
        spiNacionalidad = (Spinner) view.findViewById(R.id.ANspinnerNacionalidad);
        TextPrecio = (EditText) view.findViewById(R.id.ANtextPrecio);
        spiTipo = (Spinner) view.findViewById(R.id.ANspinnerTipo);
        spiAlcohol = (Spinner) view.findViewById(R.id.ANspinnerAlcohol);

        //Asociacion de informacion d elos spinners
        String[] arrayNac = {"$", "$$", "$$$"};
        String[] arrayTipo = {"$", "$$", "$$$"};
        String[] arrayAlcohol = {"$", "$$", "$$$"};

        ArrayAdapter<String> adapNacionalidad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayNac);
        ArrayAdapter<String> adapTipo = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayTipo);
        ArrayAdapter<String> adapAlcohol = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayAlcohol);


        spiNacionalidad.setAdapter(adapNacionalidad);
        spiTipo.setAdapter(adapTipo);
        spiAlcohol.setAdapter(adapAlcohol);

        SUBIR=(Button) view.findViewById(R.id.ANbuttonSubir);

        SUBIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recogerDatos();
                Toast.makeText(getActivity(),"Subidito",Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnadirViewModel.class);
        // TODO: Use the ViewModel



    }



    //Metodo de recogida de recogida y subida de informacion a la DB

    public void  recogerDatos() {
        //Recoleccion de informacion en el xml del fragment

        String name = TextNombre.getText().toString().trim();
        String nacionalidad = spiNacionalidad.getSelectedItem().toString();
        int precio = Integer.parseInt(TextPrecio.getText().toString().trim());
        String rangoPrecio="";
        String tipo= spiTipo.getSelectedItem().toString();
        String alcohol= spiAlcohol.getSelectedItem().toString();


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getActivity(), "Se debe ingresar un nombre", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(TextPrecio.getText().toString().trim())) {
            Toast.makeText(getActivity(), "Se debe ingresar un precio", Toast.LENGTH_LONG).show();
        } else{
            if(precio<5000){
                rangoPrecio="$";
            }else if(precio>5000 &&precio<10000){
                rangoPrecio="$$";
            }else if(precio>=10000) {
                rangoPrecio = "$$$";
            }

            //Setting all the information collected
            Cerveza newBeer = new Cerveza(name,nacionalidad,precio,rangoPrecio,tipo,alcohol);
            newBeer.setNombre(name);
            newBeer.setNacionalidad(nacionalidad);
            newBeer.setPrecio(precio);
            newBeer.setTipo(tipo);
            newBeer.setAlcohol(alcohol);

            newBeer.subirCervezas(mDatabase);
        }



    }




}