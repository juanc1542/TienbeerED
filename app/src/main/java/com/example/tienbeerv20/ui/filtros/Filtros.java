package com.example.tienbeerv20.ui.filtros;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Filtro;
import com.example.tienbeerv20.DataStructures.DoublyLinkedList;
import com.example.tienbeerv20.R;

public class Filtros extends Fragment implements View.OnClickListener{

    DoublyLinkedList listaPreferencias= new DoublyLinkedList();


    private FiltrosViewModel mViewModel;
    private CheckBox checkNacionalidad, checkTipo, checkPrecio, checkAlcohol;
    private Button btnFiltrar;
    private Spinner spiNacionalidad,spiTipo,spiPrecio,spiAlcohol;
    private NavController navController= null;

    public static Filtros newInstance() {
        return new Filtros();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.filtros_fragment, container, false);
        //Creacion y asignacion estandar de cada uno de los "botones" del fragment
        checkNacionalidad = view.findViewById(R.id.cbNac);
        checkTipo = view.findViewById(R.id.cbTipo);
        checkPrecio = view.findViewById(R.id.cbPrecio);
        checkAlcohol = view.findViewById(R.id.cbAlcohol);
        btnFiltrar=view.findViewById(R.id.btnFiltrar);


        spiNacionalidad=(Spinner) view.findViewById(R.id.FIspinnerNacionalidad);
        spiTipo = (Spinner) view.findViewById(R.id.FIspinnerTipo);
        spiPrecio = (Spinner) view.findViewById(R.id.FIspinnerPrecio);
        spiAlcohol = (Spinner) view.findViewById(R.id.FIspinnerAlcohol);

        //Asociacion de informacion d elos spinners
        String[] arrayNac = {"Alemana", "Francesa", "Colombiana","Americana","Belga","Mexicana","Española","Japonesa","Resto del mundo"};
        String[] arrayTipo = {"De Trigo", "Porter/Stout", "Lambic","Lager","Otras"};
        String[] arrayPrecio = {"Economica","Intermedia","Cara"};
        String[] arrayAlcohol = {"Sin Alcohol", "Menor a 4.5%", "Entre 4.5% y 8%", "Mayor a 8%"};

        ArrayAdapter<String> adapNacionalidad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayNac);
        ArrayAdapter<String> adapTipo = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayTipo);
        ArrayAdapter<String> adapPrecio = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayPrecio);
        ArrayAdapter<String> adapAlcohol = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayAlcohol);


        spiNacionalidad.setAdapter(adapNacionalidad);
        spiTipo.setAdapter(adapTipo);
        spiPrecio.setAdapter(adapPrecio);
        spiAlcohol.setAdapter(adapAlcohol);

        //Por cada vez que se haga check en una caja, esta se añadira a la linked list
        //donde si se hace click se selecciona la checkbox, se añade. Si se deselecciona
        //se elimina de la lista
        checkNacionalidad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkNacionalidad.isChecked()){
                    listaPreferencias.addNode("Nacionalidad");
                    Toast.makeText(getContext(), "Nacionalidad", Toast.LENGTH_SHORT).show();
                } else if(!checkNacionalidad.isChecked()){
                    Toast.makeText(getContext(), "Nacionalidad retirado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkTipo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkTipo.isChecked()){
                    listaPreferencias.addNode("Tipo");
                    Toast.makeText(getContext(), "Tipo", Toast.LENGTH_SHORT).show();
                } else if(!checkTipo.isChecked()){
                    Toast.makeText(getContext(), "Tipo deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkPrecio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkPrecio.isChecked()){
                    listaPreferencias.addNode("Precio");
                    Toast.makeText(getContext(), "Precio selected", Toast.LENGTH_SHORT).show();
                } else if(!checkPrecio.isChecked()){
                    Toast.makeText(getContext(), "Precio deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkAlcohol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkAlcohol.isChecked()){
                    listaPreferencias.addNode("Alcohol");
                    Toast.makeText(getContext(), "Alcohol selected", Toast.LENGTH_SHORT).show();
                } else if(!checkAlcohol.isChecked()){
                    Toast.makeText(getContext(), "Alcohol deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController=Navigation.findNavController(view);
        view.findViewById(R.id.btnFiltrar).setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FiltrosViewModel.class);
        // TODO: Use the ViewModel
    }

    //Inicialmente, se recoge la linked list de las prioridades en un arreglo
    //Tambien se realiza la transicion al siguiente fragment
    @Override
    public void onClick(View v) {
        if(v.getId()==btnFiltrar.getId()){
            String nacionalidadFiltro = spiNacionalidad.getSelectedItem().toString();
            String tipoFiltro = spiTipo.getSelectedItem().toString();
            String precioFiltro = spiPrecio.getSelectedItem().toString();
            String alcoholFiltro = spiAlcohol.getSelectedItem().toString();


            //Filtro filtroFinal= new Filtro();
            listaPreferencias.printNodes();
            Navigation.findNavController(v).navigate(R.id.action_nav_filtro_to_seleccionCervezas);
        }
    }




}