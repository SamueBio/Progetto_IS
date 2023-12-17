package com.example.myapplication;
public class Alloggio {
    private String nome;

    private String id;

    private String indirizzo;

    private boolean isFavourited;


    public Alloggio(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
    }
    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}

