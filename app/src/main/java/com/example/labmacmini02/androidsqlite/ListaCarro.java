package com.example.labmacmini02.androidsqlite;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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




        //AQUI VOU BUSCAR NO BANCO E MOSTRAR PARA VERIFICAR SE ALGO FOI GRAVADO.
        //Carro vrCarro = null;
        //for (int i=0; i< listaCarros.size();i++) {
            //vrCarro = listaCarros.get(i);
            //Toast.makeText( this, vrCarro.getNome() +" "+vrCarro.getPlaca()+" "+vrCarro.getAno(), Toast.LENGTH_SHORT).show();
            //SystemClock.sleep(1000);
        //}



    }
}
