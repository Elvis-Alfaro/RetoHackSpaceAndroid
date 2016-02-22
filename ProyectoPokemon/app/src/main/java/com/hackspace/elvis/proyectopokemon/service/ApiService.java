package com.hackspace.elvis.proyectopokemon.service;

import com.hackspace.elvis.proyectopokemon.entity.PokemonEntity;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by elvis on 21/02/2016.
 */
public interface ApiService {
    @GET("/lista_pokemons.php")
    void getPokemons(Callback<ArrayList<PokemonEntity>> callback);
}
