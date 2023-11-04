package com.example.myapplication;
public class Alloggio {
    private String nome;
    private String indirizzo;

    public Alloggio(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}

