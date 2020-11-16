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

public class AdaptadorTres extends RecyclerView.Adapter<AdaptadorTres.ViewHolderCervezas> {
    ArrayList<Cerveza> listaCerveza;
    ArrayList<Cerveza> seleccionados = new ArrayList<Cerveza>();
    private View.OnClickListener listener;

    public AdaptadorTres(ArrayList<Cerveza> listaCerveza) {
        this.listaCerveza = listaCerveza;
    }

    @NonNull
    @Override
    public AdaptadorTres.ViewHolderCervezas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloque_adaptador_seleccion,parent,false);

        return new AdaptadorTres.ViewHolderCervezas(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorTres.ViewHolderCervezas holder, final int position) {
        holder.nombre.setText(listaCerveza.get(position).getNombre());
        holder.nacionalidad.setText(listaCerveza.get(position).getNacionalidad());
        holder.tipo.setText(listaCerveza.get(position).getTipo());
        holder.alcohol.setText(listaCerveza.get(position).getAlcohol());
        holder.precio.setText("$"+listaCerveza.get(position).getPrecio());

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

        public ViewHolderCervezas(@NonNull View itemView) {
            super(itemView);

            nombre=(TextView) itemView.findViewById(R.id.nametxtSel);
            nacionalidad=(TextView) itemView.findViewById(R.id.nacionalidadtxtSel);
            tipo=(TextView) itemView.findViewById(R.id.tipotxtSel);
            alcohol=(TextView) itemView.findViewById(R.id.alcoholtxtSel);
            precio=(TextView) itemView.findViewById(R.id.preciotxtSel);



        }
    }
}