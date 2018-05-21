package com.example.labmacmini02.androidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.labmacmini02.androidsqlite.model.Carro;

import java.util.ArrayList;

public class ListaCarro extends AppCompatActivity {



    ArrayList<Carro> listaCarros = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carro);


        CamadaBanco bd = new CamadaBanco(this, "ListaCarros", 1);
        listaCarros = bd.listaCarros();

        RecyclerView listaRecycleView = null;
        listaRecycleView = (RecyclerView) findViewById(R.id.listaPrincipal);
        listaRecycleView.setLayoutManager(new LinearLayoutManager(this));
        listaRecycleView.setItemAnimator(new DefaultItemAnimator());
        listaRecycleView.setHasFixedSize(true);


        AdaptadorCarros adapt = new AdaptadorCarros(this, listaCarros);
        listaRecycleView.setAdapter(adapt);


    }
}
