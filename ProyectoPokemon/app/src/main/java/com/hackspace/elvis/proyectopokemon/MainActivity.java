package com.hackspace.elvis.proyectopokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hackspace.elvis.proyectopokemon.entity.PokemonEntity;
import com.hackspace.elvis.proyectopokemon.service.ApiImplementation;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtPass;
    Button btnAceptar;
    ArrayList<PokemonEntity> pokemones = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.usuario);
        txtPass = (EditText) findViewById(R.id.pass);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiImplementation.getApiService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
                    @Override
                    public void success(ArrayList<PokemonEntity> listaPokemon, Response response) {
                        boolean login = false;
                        for (PokemonEntity pokemon : listaPokemon) {
                            if (txtUsuario.getText().toString().equals(pokemon.getNombre().toString())
                                    && txtPass.getText().toString().equals(pokemon.getTipo().toString())) {

                                Toast.makeText(MainActivity.this, "Ingresaste correctamente", Toast.LENGTH_LONG).show();
                                login = true;
                              /*  Intent intent = new Intent(getApplicationContext(), DetallePokemon.class);
                                intent.putExtra("nombre", pokemon.getNombre().toString());
                                intent.putExtra("tipo", pokemon.getTipo().toString());
                                startActivity(intent);*/
                            }
                        }
                        if (login) {
                            Intent intentPokemones = new Intent(getApplicationContext(), DetallePokemon.class);
                            startActivity(intentPokemones);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "No se encontro ninguna coincidencia", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.i("Respuesta", "Algo salio mal");
                    }
                });
            }
        });


    }

    public ArrayList<PokemonEntity> getPokemones(){
        return pokemones;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
