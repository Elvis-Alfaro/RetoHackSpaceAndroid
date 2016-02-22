package com.hackspace.elvis.proyectopokemon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hackspace.elvis.proyectopokemon.adaptador.ListAdapter;
import com.hackspace.elvis.proyectopokemon.entity.PokemonEntity;
import com.hackspace.elvis.proyectopokemon.service.ApiImplementation;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by elvis on 21/02/2016.
 */
public class DetallePokemon extends Activity {

    ArrayList<PokemonEntity> pokemones = new ArrayList<>();
    ListView listaPokemones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_pokemon);

        listaPokemones = (ListView) findViewById(R.id.listaPokemon);

        ApiImplementation.getApiService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> listaPokemon, Response response) {
                for (PokemonEntity pokemon : listaPokemon) {

                    PokemonEntity entidad = new PokemonEntity(pokemon.getId(), pokemon.getNombre(), pokemon.getTipo(), pokemon.getImagen());
                    pokemones.add(entidad);
                }

                ListAdapter adapter = new ListAdapter(pokemones, getApplicationContext());
                listaPokemones.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("Respuesta", "Algo salio mal");
            }
        });

    }
}
