package br.usjt.ads20.appfilmes.model;

import android.graphics.Bitmap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dados {
    private static ArrayList<Filme> filmes;
    private static ArrayList<Poster> imagens;

    public static ArrayList<Poster> getImagens() {
        return imagens;
    }

    public static void setImagens(ArrayList<Poster> imagens) {
        Dados.imagens = imagens;
    }

    public static void setFilmes(ArrayList<Filme> pFilmes){
        filmes = pFilmes;
    }

    public static Filme[] buscaFilmes(String chave){
        ArrayList<Filme> lista = filmes;
        ArrayList<Filme> filtro;
        Filme[] filmes;
        if(chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for(Filme filme: lista){
                String nome = filme.getTitulo();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(filme);
                }
            }
        }
        filmes = filtro.toArray(new Filme[0]);
        Arrays.sort(filmes);
        return filmes;
    }

    public static Poster[] buscaPosters(String chave){
        ArrayList<Poster> lista = imagens;
        ArrayList<Poster> filtro;
        Poster[] posters;
        if(chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for(Poster poster: lista){
                String nome = poster.getTitulo();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(poster);
                }
            }
        }
        posters = filtro.toArray(new Poster[0]);
        Arrays.sort(posters);
        return posters;
    }

    public static ArrayList<Genero> criaGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        lista.add(new Genero(1, "Não Cadastrado"));
        lista.add(new Genero(28, "Ação"));
        lista.add(new Genero(12, "Aventura"));
        lista.add(new Genero(16, "Animação"));
        lista.add(new Genero(35, "Comédia"));
        lista.add(new Genero(80, "Crime"));
        lista.add(new Genero(99, "Documentário"));
        lista.add(new Genero(18, "Drama"));
        lista.add(new Genero(10751, "Família"));
        lista.add(new Genero(14, "Fantasia"));
        lista.add(new Genero(36, "História"));
        lista.add(new Genero(27, "Horror"));
        lista.add(new Genero(10402, "Musical"));
        lista.add(new Genero(9648, "Mistério"));
        lista.add(new Genero(10749, "Romance"));
        lista.add(new Genero(878, "Ficção Científica"));
        lista.add(new Genero(10770, "Filme para TV"));
        lista.add(new Genero(53, "Suspense"));
        lista.add(new Genero(10752, "Guerra"));
        lista.add(new Genero(37, "Western"));

        return lista;
    }

}
