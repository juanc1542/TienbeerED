package com.example.tienbeerv20.ui.Recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;
import com.example.tienbeerv20.ui.SeleccionCervezas.SeleccionCervezas;

import java.util.ArrayList;

public class AdaptadorDos extends RecyclerView.Adapter<AdaptadorDos.ViewHolderCervezas> {
    ArrayList<Cerveza> listaCerveza;
    ArrayList<Cerveza> seleccionados = new ArrayList<Cerveza>();
    private View.OnClickListener listener;

    public AdaptadorDos(ArrayList<Cerveza> listaCerveza) {
        this.listaCerveza = listaCerveza;
    }

    @NonNull
    @Override
    public AdaptadorDos.ViewHolderCervezas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloque_adaptador,parent,false);

        return new AdaptadorDos.ViewHolderCervezas(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDos.ViewHolderCervezas holder, final int position) {
        holder.nombre.setText(listaCerveza.get(position).getNombre());
        holder.nacionalidad.setText(listaCerveza.get(position).getNacionalidad());
        holder.tipo.setText(listaCerveza.get(position).getTipo());
        holder.alcohol.setText(listaCerveza.get(position).getAlcohol());
        holder.precio.setText("$"+listaCerveza.get(position).getPrecio());


        //Guardado de las cervezas seleccionadas por el usuario
        holder.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seleccionados.size() <= 3){
                    seleccionados.add(listaCerveza.get(position));
                Toast.makeText(v.getContext(), "Elegiste "+listaCerveza.get(position).getNombre()+", llevas "+seleccionados.size(), Toast.LENGTH_SHORT).show();
            } else {
                    SeleccionCervezas fragment = new SeleccionCervezas();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("key", seleccionados);
                    fragment.setArguments(bundle);
                    Navigation.findNavController(v).navigate(R.id.action_busqueda_to_nav_filtro,bundle);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaCerveza.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public class ViewHolderCervezas extends RecyclerView.ViewHolder {
        TextView nombre, nacionalidad,tipo,alcohol, precio;
        ImageButton btnAdicionar;

        public ViewHolderCervezas(@NonNull View itemView) {
            super(itemView);
            btnAdicionar=(ImageButton) itemView.findViewById(R.id.imgAdicionar);

            nombre=(TextView) itemView.findViewById(R.id.nametxt);
            nacionalidad=(TextView) itemView.findViewById(R.id.nacionalidadtxt);
            tipo=(TextView) itemView.findViewById(R.id.tipotxt);
            alcohol=(TextView) itemView.findViewById(R.id.alcoholtxt);
            precio=(TextView) itemView.findViewById(R.id.preciotxt);



        }
    }
}