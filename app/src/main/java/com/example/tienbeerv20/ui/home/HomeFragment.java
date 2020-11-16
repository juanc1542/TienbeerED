package com.example.tienbeerv20.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.Data.Tests;
import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.SeleccionCervezas.SeleccionCervezas;
import com.example.tienbeerv20.ui.favoritos.FavoritosFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    ArrayList<Cerveza> ops = new ArrayList<Cerveza>();


    private Button dejanos,tresytres,todoyo;

    private NavController navController= null;

    private FirebaseDatabase BD;
    private DatabaseReference DBref;

    String llaveSeleccion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        dejanos=(Button) root.findViewById(R.id.btnDejanos);
        tresytres=(Button) root.findViewById(R.id.btn3y3);
        todoyo=(Button) root.findViewById(R.id.btnArmalo);



        //final TextView textView = root.findViewById(R.id.text_home);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });


        BD = FirebaseDatabase.getInstance();
        DBref = BD.getReference("Cervezas");
        DBref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    ops.add(ds.getValue(Cerveza.class));
                    System.out.println("AYUDAAAAA"+ops.get(0).getNacionalidad());
                    //Toast.makeText(getContext(), "Conexion Exitosa", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        return root;






    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController=Navigation.findNavController(view);
        view.findViewById(R.id.btnDejanos).setOnClickListener(this);
        view.findViewById(R.id.btn3y3).setOnClickListener(this);
        view.findViewById(R.id.btnArmalo).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==dejanos.getId()){
            llaveSeleccion="r";
            SeleccionCervezas fragment = new SeleccionCervezas();
            Bundle bundle = new Bundle();
            bundle.putSerializable("llave", llaveSeleccion);
            fragment.setArguments(bundle);
            Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_filtro,bundle);

        }else if(v.getId()==tresytres.getId()){
            llaveSeleccion="GeneracionAMedias";
            SeleccionCervezas fragment = new SeleccionCervezas();
            Bundle bundle = new Bundle();
            bundle.putString("llave", llaveSeleccion);
            bundle.putSerializable("llaveArreglo", ops);
            fragment.setArguments(bundle);
            Navigation.findNavController(v).navigate(R.id.action_nav_home_to_busqueda,bundle);
            //No se va directamente a los filtros porque el RecycledView no permite recibir informacion del activity
            //llaveSeleccion="a";
            //Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_filtro,bundle);

        }else if(v.getId()==todoyo.getId()){
            llaveSeleccion="GeneracionManual";
            SeleccionCervezas fragment = new SeleccionCervezas();
            Bundle bundle = new Bundle();
            bundle.putString("llave", llaveSeleccion);
            bundle.putSerializable("llaveArreglo", ops);
            fragment.setArguments(bundle);
            Navigation.findNavController(v).navigate(R.id.action_nav_home_to_busqueda,bundle);
        }
    }
}