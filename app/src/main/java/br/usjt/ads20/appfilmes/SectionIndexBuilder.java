package br.usjt.ads20.appfilmes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

import br.usjt.ads20.appfilmes.model.Filme;

public class SectionIndexBuilder {

    public static Object[] buildSectionHeaders(Filme[] filmes) {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used = new TreeSet<>();

        if(filmes != null) {
            for (Filme filme : filmes) {
                String letter = filme.getTitulo().substring(0, 1);
                if (!used.contains(letter)) {
                    results.add(letter);
                }
                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Filme[] filmes) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(filmes != null){
            for(int i = 0; i < filmes.length; i++){
                String letter = filmes[i].getTitulo().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }
        return results;
    }

    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Filme[] filmes) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(filmes != null){
            for(int i = 0; i < filmes.length; i++){
                String letter = filmes[i].getTitulo().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                }
                results.put(i, section);
            }
        }
        return results;
    }
}
