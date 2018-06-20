package com.example.pc.mecagoenmismuertosv5.adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.mecagoenmismuertosv5.R;
import com.example.pc.mecagoenmismuertosv5.entitats.Usuari;

import java.util.ArrayList;

/**
 * Created by Pc on 16/01/2018.
 */

public class LlistaUsuarisAdapter extends RecyclerView.Adapter<LlistaUsuarisAdapter.UsuarisViewHolder> {

    ArrayList<Usuari> llistaUsuaris;

    public LlistaUsuarisAdapter(ArrayList<Usuari> llistaUsuari) {
        this.llistaUsuaris = llistaUsuari;
    }

    @Override
    public UsuarisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_usuaris,null,false);
        return new UsuarisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarisViewHolder holder, int position) {
        holder.UserID.setText(String.valueOf(llistaUsuaris.get(position).getId_usuari()));
        holder.UserNom.setText(llistaUsuaris.get(position).getNom());
        holder.UserCognom.setText(llistaUsuaris.get(position).getCognom());
        holder.UserTelefon.setText(llistaUsuaris.get(position).getTelefon());
    }

    @Override
    public int getItemCount() {
        return llistaUsuaris.size();
    }

    public class UsuarisViewHolder extends RecyclerView.ViewHolder {

        TextView UserID, UserNom, UserCognom, UserTelefon;

        public UsuarisViewHolder(View itemView) {
            super(itemView);
            UserID = (TextView) itemView.findViewById(R.id.UserID);
            UserNom = (TextView) itemView.findViewById(R.id.UserNom);
            UserCognom = (TextView) itemView.findViewById(R.id.UserCognom);
            UserTelefon = (TextView) itemView.findViewById(R.id.UserTelefon);
        }
    }
}
