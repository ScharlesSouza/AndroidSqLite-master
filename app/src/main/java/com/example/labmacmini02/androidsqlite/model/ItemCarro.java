package com.example.labmacmini02.androidsqlite.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.labmacmini02.androidsqlite.R;

public class ItemCarro extends RecyclerView.ViewHolder {


    TextView textNome = null;
    TextView textPlaca = null;
    TextView textAno = null;


    public ItemCarro(View view){
        super(view);


        this.textNome = (TextView)view.findViewById(R.id.textNome);
        this.textPlaca = (TextView)view.findViewById(R.id.textPlaca);
        this.textAno = (TextView)view.findViewById(R.id.textAno);


    }


    public TextView getTextNome() {
        return textNome;
    }

    public TextView getTextPlaca() {
        return textPlaca;
    }

    public TextView getTextAno() {
        return textAno;
    }

}
