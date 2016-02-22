package com.hackspace.elvis.proyectopokemon.entity;

/**
 * Created by elvis on 21/02/2016.
 */
public class PokemonEntity {
    private int id;
    private String nombre;
    private String tipo;
    private String imagen;

    public PokemonEntity(int id, String nombre, String tipo, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
