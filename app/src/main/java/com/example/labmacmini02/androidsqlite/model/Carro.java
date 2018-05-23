package com.example.labmacmini02.androidsqlite.model;

/**
 * Created by labmacmini02 on 16/05/18.
 */

public class Carro {



    public Integer get_int() {
        return _int;
    }

    public void set_int(Integer _int) {
        this._int = _int;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getId() { return _id;  }

    public void setId(Integer id) { this._id = id; }


    private Integer _int = null;
    private String nome = null;
    private String placa = null;
    private String ano = null;
    private Integer _id = null;


}
