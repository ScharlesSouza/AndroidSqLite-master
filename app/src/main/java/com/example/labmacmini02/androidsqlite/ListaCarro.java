package com.example.labmacmini02.androidsqlite;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.labmacmini02.androidsqlite.model.Carro;

import java.util.ArrayList;

public class ListaCarro extends AppCompatActivity {



    ArrayList<Carro> listaCarros = null;
    CamadaBanco bd = null;
    RecyclerView listaRecycleView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carro);

        listaRecycleView = (RecyclerView) findViewById(R.id.listaPrincipal);
        atualizaRecycleView(listaRecycleView);
    }


    //ATUALIZA A LISTA DE CARROS BUSCANDO NO BANCO
    private ArrayList<Carro> atualizaLista(){

        bd = new CamadaBanco(this, "BDCarros", 1);
        listaCarros = bd.listaCarros();
        return listaCarros;
    }

    //METODO PARA ATUALIZAR O RECYCLEVIEW
    private void atualizaRecycleView(RecyclerView recycleview){

        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setItemAnimator(new DefaultItemAnimator());
        recycleview.setHasFixedSize(true);

        //PASSO COMO PARAMETRO AO ADAPTADORCARROS, O CONTEXT, A LISTA DE CARROS E O METODO QUE CRIA O TRATAMENTO LISTENER.
        AdaptadorCarros adapt = new AdaptadorCarros(this, atualizaLista(), criaListener());
        recycleview.setAdapter(adapt);
    }


    //METODO PARA INSTANCIAR O OBJETO E IMPLEMENTAR O METODO OBRIGATORIO
    private AdapterListener criaListener(){

        //CRIACAO DO OBJETO INTEFACE LISTENER
        return new AdapterListener() {

            //IMPLEMENTACAO OBRIGATORIA DO METODO DA INTERFACE LISTENER
            @Override
            public void listenerRemoveCarro(View view, final int posicao) {
                //listaRecycleView = view.findViewById(R.id.listaPrincipal);
                atualizaRecycleView(listaRecycleView);
            }

        };

    }
}

// INTERFACE LISTENER
interface AdapterListener{
    void listenerRemoveCarro(View view, int posicao);
}
