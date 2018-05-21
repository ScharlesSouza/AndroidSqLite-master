package com.example.labmacmini02.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CamadaBanco vrbancoDados = null;
    EditText campoNome=null;
    EditText campoPlaca=null;
    EditText campoAno=null;

    Button buttonGravar = null;
    Button buttonLista = null;
    Context contexto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = (EditText)findViewById(R.id.editTextNome);
        campoPlaca = (EditText)findViewById(R.id.editTextPlaca);
        campoAno = (EditText) findViewById(R.id.editTextAno);
        buttonGravar = (Button)findViewById(R.id.buttonGravar);
        buttonLista = (Button)findViewById(R.id.buttonLista);


        vrbancoDados = new CamadaBanco(this, "BDCarros", 1);

        buttonGravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ContentValues dados = new ContentValues();
                dados.put("nome", campoNome.getText().toString());
                dados.put("placa", campoPlaca.getText().toString());
                dados.put("ano", campoAno.getText().toString());
                vrbancoDados.insereCarros(dados);

                Log.i("Info", vrbancoDados.listaCarros().toString());
        }
        });


        buttonLista.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                contexto = view.getContext();
                Intent intent = new Intent(contexto, ListaCarro.class);
                contexto.startActivity(intent);

            }
        });











    }
}
