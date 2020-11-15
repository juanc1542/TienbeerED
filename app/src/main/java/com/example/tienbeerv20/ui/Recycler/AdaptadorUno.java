package com.example.tienbeerv20.ui.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienbeerv20.Data.Cerveza;
import com.example.tienbeerv20.R;

import java.util.ArrayList;

public class AdaptadorUno extends RecyclerView.Adapter<AdaptadorUno.ViewHolderCervezas> {
    ArrayList<Cerveza> listaCerveza;
    private View.OnClickListener listener;

    public AdaptadorUno(ArrayList<Cerveza> listaCerveza) {
        this.listaCerveza = listaCerveza;
    }

    @NonNull
    @Override
    public AdaptadorUno.ViewHolderCervezas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloque_adaptador,parent,false);

        return new AdaptadorUno.ViewHolderCervezas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUno.ViewHolderCervezas holder, int position) {
        holder.calif.setText(listaCerveza.get(position).getNombre());
        holder.review.setText(listaCerveza.get(position).getNacionalidad());
    }



    @Override
    public int getItemCount() {
        return listaCerveza.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public class ViewHolderCervezas extends RecyclerView.ViewHolder {
        TextView calif, review;

        public ViewHolderCervezas(@NonNull View itemView) {
            super(itemView);


            calif=(TextView) itemView.findViewById(R.id.califtxt);
            review=(TextView) itemView.findViewById(R.id.rewtxt);
        }
    }
}