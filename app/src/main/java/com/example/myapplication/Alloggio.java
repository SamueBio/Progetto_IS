package com.example.myapplication;
public class Alloggio {
    private String nome;

    private String id;

    private String indirizzo;

    private boolean isFavorited;


    public Alloggio(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }
    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}

