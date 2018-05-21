package com.example.labmacmini02.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.labmacmini02.androidsqlite.model.Carro;

import java.util.ArrayList;

/**
 * Created by labmacmini02 on 16/05/18.
 */

public class CamadaBanco extends SQLiteOpenHelper {
    String[] scriptCriaBanco = {"create table carro(_id integer primary key autoincrement, nome text not null, placa text not null, ano text not null);"};
    Carro vrCarro = null;

    public final String scriptApagaDB = "DROP TABLE IF EXISTS carro";
    Context vrContexto = null;


    CamadaBanco(Context contexto, String nome, int versao){

        super(contexto, nome, null, versao);
        vrContexto = contexto;

    }


    @Override
    //CRIAÇÃO
    public void onCreate(SQLiteDatabase db) {
        for(int iIndex=0; iIndex < scriptCriaBanco.length; iIndex++){

            db.execSQL(scriptCriaBanco[iIndex]);
        }

    }

    //INSERÇÃO
    public void insereCarros(ContentValues dados){
        SQLiteDatabase bancodados = this.getWritableDatabase();
        bancodados.insert("carro", null, dados);
        Toast.makeText( vrContexto, "Inserção Realizada", Toast.LENGTH_SHORT).show();

        //AQUI VOU BUSCAR NO BANCO E MOSTRAR PARA VERIFICAR SE ALGO FOI GRAVADO.
        vrCarro = listaCarros().get(1);
        Toast.makeText( vrContexto, vrCarro.getNome() +" "+vrCarro.getPlaca()+" "+vrCarro.getAno(), Toast.LENGTH_SHORT).show();


    }

    //REMOÇÃO
    public void removeCarro(String placa){

    }

    //CONSULTA
    public ArrayList<Carro> listaCarros(){

        ArrayList<Carro> lista = new ArrayList<Carro>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        Cursor cursor = bancoDados.query("carro", new String[]{"nome", "placa", "ano"},null, null, null, null, null);
        vrCarro = new Carro();


        while(cursor.moveToNext()){
           vrCarro.setNome(cursor.getString(0));
           vrCarro.setPlaca(cursor.getString(1));
           vrCarro.setAno(cursor.getString(2));

            lista.add(vrCarro);
        }

        return lista;
    }

    @Override
    //ATUALIZAÇÃO DO BANCO
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaDB);

    }
}
