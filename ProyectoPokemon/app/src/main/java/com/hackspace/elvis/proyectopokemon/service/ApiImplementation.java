package com.hackspace.elvis.proyectopokemon.service;

import retrofit.RestAdapter;

/**
 * Created by elvis on 21/02/2016.
 */
public class ApiImplementation {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://victorcasass.com/api/")
            .build();

    public static ApiService getApiService(){
        return restAdapter.create(ApiService.class);
    }
}
