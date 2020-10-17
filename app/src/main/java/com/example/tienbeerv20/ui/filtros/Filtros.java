package com.example.tienbeerv20.ui.filtros;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.Filtro;
import com.example.tienbeerv20.Data.SixPack;
import com.example.tienbeerv20.DataStructures.DoublyLinkedList;
import com.example.tienbeerv20.Logic.SixPackGenerator;
import com.example.tienbeerv20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Filtros extends Fragment implements View.OnClickListener{

    DoublyLinkedList listaPreferencias= new DoublyLinkedList();


    private FiltrosViewModel mViewModel;
    private CheckBox checkNacionalidad, checkTipo, checkPrecio, checkAlcohol;
    private Button btnFiltrar;
    private Spinner spiNacionalidad,spiTipo,spiPrecio,spiAlcohol;
    private NavController navController= null;
    private Switch switchRepetidas;
    private FirebaseDatabase BD;
    private DatabaseReference DBref;
    ArrayList<Cerveza> cervezas = new ArrayList<>();
    ArrayList<Cerveza> cervezasPrimerFiltro = new ArrayList<>();

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
        switchRepetidas=(Switch)view.findViewById(R.id.switchRepetidas);

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

                } else if(!checkAlcohol.isChecked()){
                    Toast.makeText(getContext(), "Alcohol deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BD = FirebaseDatabase.getInstance();
        DBref = BD.getReference("Cervezas");
        DBref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    cervezas.add(ds.getValue(Cerveza.class));
                    Toast.makeText(getContext(), "Conexion Exitosa", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
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
        boolean repetidas=false;
        String[][] filtroF;


        //Cuando se oprima el boton, se ejecutan las siguientes tareas
        if(v.getId()==btnFiltrar.getId()){
            //Se verifica el valor del switch, en caso de estar activado se pasa repetidas a true
            if(switchRepetidas.isChecked()){
                Toast.makeText(getContext(), "Activated", Toast.LENGTH_SHORT).show();
                repetidas=true;
            }

            String nacionalidadFiltro = spiNacionalidad.getSelectedItem().toString();
            String tipoFiltro = spiTipo.getSelectedItem().toString();
            String precioFiltro = spiPrecio.getSelectedItem().toString();
            String alcoholFiltro = spiAlcohol.getSelectedItem().toString();
            //Se ejecuta el metodo encargado de asignar los tipos de filtro
            filtroF=listaPreferencias.asignTo2DArray();

            for (int i = 0; i < 4; i++) {
                if(filtroF[i][0].equals("Nacionalidad")){
                    filtroF[i][1]=nacionalidadFiltro;
                }else if(filtroF[i][0].equals("Tipo")){
                    filtroF[i][1]=tipoFiltro;
                }else if(filtroF[i][0].equals("Alcohol")){
                    filtroF[i][1]=alcoholFiltro;
                }else if(filtroF[i][0].equals("Precio")){
                    filtroF[i][1]=precioFiltro;
                }
            }



            switch (filtroF[0][0]){
                case "Nacionalidad":
                    for (int i = 0; i < cervezas.size(); i++) {
                        if(cervezas.get(i).getNacionalidad().equals(filtroF[0][1]))
                            cervezasPrimerFiltro.add(cervezas.get(i));
                    }
                    break;
                case "Tipo":
                    for (int i = 0; i < cervezas.size(); i++) {
                        if(cervezas.get(i).getTipo().equals(filtroF[0][1]))
                            cervezasPrimerFiltro.add(cervezas.get(i));
                    }
                    break;
                case "Alcohol":
                    for (int i = 0; i < cervezas.size(); i++) {
                        if(cervezas.get(i).getAlcohol().equals(filtroF[0][1]))
                            cervezasPrimerFiltro.add(cervezas.get(i));
                    }
                    break;
                case "Precio":
                    for (int i = 0; i < cervezas.size(); i++) {
                        if(cervezas.get(i).getRangoPrecio().equals(filtroF[0][1]))
                            cervezasPrimerFiltro.add(cervezas.get(i));
                    }
                    break;
            }

            Filtro filtroFinal= new Filtro(filtroF,repetidas);

            SixPackGenerator sixPack= new SixPackGenerator();
            sixPack.generarSixpack(filtroFinal,cervezasPrimerFiltro,"r");

            listaPreferencias.printNodes();
            Navigation.findNavController(v).navigate(R.id.action_nav_filtro_to_seleccionCervezas);
        }
    }




}