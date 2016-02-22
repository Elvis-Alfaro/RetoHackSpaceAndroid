package com.hackspace.elvis.proyectopokemon.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackspace.elvis.proyectopokemon.entity.PokemonEntity;
import com.hackspace.elvis.proyectopokemon.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by elvis on 21/02/2016.
 */
public class ListAdapter extends BaseAdapter {

    ArrayList<PokemonEntity> listaPokemon;
    LayoutInflater inflater;
    Context context;

    public ListAdapter(ArrayList<PokemonEntity> listaPokemon, Context context) {
        this.listaPokemon = listaPokemon;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_pokemon, parent, false);

        ImageView imagen = (ImageView) view.findViewById(R.id.imagenPokemon);
        TextView nombre = (TextView) view.findViewById(R.id.txtNombrePokemon);
        TextView tipo = (TextView) view.findViewById(R.id.txtTipoPokemon);

        Picasso.with(context).load(listaPokemon.get(position).getImagen()).into(imagen);
        nombre.setText(listaPokemon.get(position).getNombre());
        tipo.setText(listaPokemon.get(position).getTipo());
        return view;
    }
}
