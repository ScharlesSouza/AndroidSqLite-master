package com.example.labmacmini02.androidsqlite;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.labmacmini02.androidsqlite.model.Carro;
import com.example.labmacmini02.androidsqlite.model.ItemCarro;

import java.util.ArrayList;

public class AdaptadorCarros extends RecyclerView.Adapter<ItemCarro>{

    Context contexto = null;
    ArrayList<Carro> lista = null;
    private AlertDialog alerta;

    AdaptadorCarros(Context contexto, ArrayList<Carro> lista){

        this.contexto = contexto;
        this.lista = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */
    //@NonNull
    @Override
    public ItemCarro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.activity_item_carro, parent,false );
        ItemCarro item = new ItemCarro(celula);
        return item;
    }
    /*
     * Método que recebe o ViewHolder e a posição da lista.
     * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
     * É onde a mágica acontece!
     * */
    @Override
    public void onBindViewHolder(@NonNull ItemCarro holder, final int position) {
        Carro carro = lista.get(position);



        holder.getTextNome().setText(carro.getNome());
        holder.getTextPlaca().setText(carro.getPlaca());
        holder.getTextAno().setText(carro.getAno());

        /*
            holder.getTextoNome().setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    contexto = view.getContext();
                    Intent intent = new Intent(contexto, ActivityDetails.class);
                    String posicao = Integer.toString(position);
                    Log.d("posicao", posicao);
                    intent.putExtra("Nome", lista.get(position).material);



                    contexto.startActivity(intent);


                }



            });
        */

        holder.getTextNome().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Titulo");
                //define a mensagem
                builder.setMessage("Apagar " + lista.get(position).getNome());
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //NetworkUtils.Apagar(lista.get(position));
                        Toast.makeText(contexto, lista.get(position).getNome()+" Apagada", Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
                return true;
            }

        });

    }


    //METODO QUE DETERMINA QUANTOS ITENS VAI TER NA LISTA
    /*
     * Método que deverá retornar quantos itens há na lista.
     * Aconselha-se verificar se a lista não está nula como no exemplo,
     * pois ao tentar recuperar a quantidade da lista nula pode gerar
     * um erro em tempo de execução (NullPointerException).
     * */
    @Override
    public int getItemCount() {

        return (lista != null)? lista.size() : 0;
    }


}