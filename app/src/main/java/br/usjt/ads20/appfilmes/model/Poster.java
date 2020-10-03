package br.usjt.ads20.appfilmes.model;

import android.graphics.Bitmap;

public class Poster implements Comparable<Poster>{
    private int id;
    private String titulo;
    private Bitmap poster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Bitmap getPoster() {
        return poster;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }

    @Override
    public int compareTo(Poster poster) {
        return titulo.compareTo(poster.getTitulo());
    }
}
