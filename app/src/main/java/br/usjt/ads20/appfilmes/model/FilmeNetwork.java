package br.usjt.ads20.appfilmes.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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

        Log.d("FilmeNetwork.buscarFilmes:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            System.out.println(retorno);
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
                JSONArray generos = item.getJSONArray("genre_ids");
                Genero genero = new Genero();
                genero.setId(generos.getInt(0));
                filme.setGenero(genero);
                filmes.add(filme);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return filmes;
    }

    public static ArrayList<Genero> buscarGeneros(String url) throws IOException {
        ArrayList<Genero> generos = new ArrayList<>();

        OkHttpClient client = new OkHttpClient();

        Log.d("FilmeNetwork.buscarGeneros:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            System.out.println(retorno);
            JSONArray lista = retorno.getJSONArray("genres");
            for(int i = 0; i < lista.length(); i++){
                Genero genero = new Genero();
                JSONObject item = (JSONObject) lista.get(i);
                genero.setId(item.getInt("id"));
                genero.setNome(item.getString("name"));
                generos.add(genero);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return generos;
    }

    public static String buscarDiretores(String url) throws IOException {
        String diretor = "";
        ArrayList<String> diretores = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Log.d("FilmeNetwork.buscarDiretores:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            JSONArray lista = retorno.getJSONArray("crew");
            for(int i = 0; i < lista.length(); i++) {
                JSONObject item = (JSONObject)lista.get(i);
                //System.out.println(item);
                if (item.getString("job").equals("Director")) {
                    diretores.add(item.getString("name"));
                }
            }
            if(diretores.size()==1){
                diretor = diretores.get(0);
            } else if(diretores.size()==2){
                diretor = diretores.get(0)+" & "+diretores.get(1);
            } else if(diretores.size()>2){
                for(int j = 0; j < diretores.size(); j++){
                    if(j == diretores.size()-1){
                        diretor += " & "+diretores.get(j);
                    } else {
                        diretor += ", "+diretores.get(j);
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return diretor;
    }

    public static Bitmap buscarImagens(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Bitmap img = null;

        Log.d("FilmeNetwork.buscarImagens:url", url);
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnected();
    }

}
