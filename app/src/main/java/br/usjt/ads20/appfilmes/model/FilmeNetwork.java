package br.usjt.ads20.appfilmes.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FilmeNetwork {

    public static ArrayList<Filme> buscarFilmes(String url) throws IOException {
        ArrayList<Filme> filmes = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            JSONArray lista = retorno.getJSONArray("results");
            for(int i = 0; i < lista.length(); i++){
                Filme filme = new Filme();
                JSONObject item = (JSONObject) lista.get(i);

                filme.setId(item.getInt("id"));
                filme.setTitulo(item.getString("title"));
                filme.setDescricao(item.getString("overview"));
                filme.setBackdropPath(item.getString("backdrop_path"));
                filme.setPosterPath(item.getString("poster_path"));
                filme.setPopularidade(item.getDouble("popularity"));
                filme.setDiretor("Não identificado");
                try {
                    filme.setDataLancamento(formatter.parse(item.getString("release_date")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Genero genero = new Genero(1, "Ação");
                filme.setGenero(genero);
                filmes.add(filme);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return filmes;
    }
}
