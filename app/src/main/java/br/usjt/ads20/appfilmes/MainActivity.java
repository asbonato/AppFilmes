package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Filme;
import br.usjt.ads20.appfilmes.model.FilmeDb;
import br.usjt.ads20.appfilmes.model.FilmeNetwork;
import br.usjt.ads20.appfilmes.model.Genero;
import br.usjt.ads20.appfilmes.model.Poster;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private ProgressBar progressBar;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String FILMES = "br.usjt.ads20.appfilmes.filmes";
    private String url = "https://api.themoviedb.org/3/movie/popular?" +
            "language=%s-%s&page=1&api_key=";
    private String imgUrl = "https://image.tmdb.org/t/p/w300";
    private String genUrl = "https://api.themoviedb.org/3/genre/movie/list?" +
            "language=%s-%s&api_key=";
    private String dirUrl = "https://api.themoviedb.org/3/movie/%s/credits?api_key=";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        context = this;
    }

    public void buscarFilmes(View view){
        if (FilmeNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            String idioma = this.getResources().getString(R.string.idioma);
            String pais = this.getResources().getString(R.string.pais);
            new DownloadJsonFilmes().execute(String.format(url,idioma,pais) + getKey(),
                    String.format(genUrl,idioma,pais) + getKey(),
                    dirUrl + getKey());
        } else {
            String msg = this.getResources().getString(R.string.erro_rede);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
            progressBar.setVisibility(View.VISIBLE);
            new CarregaFilmesDb().execute();
        }
    }

    private class DownloadJsonFilmes extends AsyncTask<String, Void, ArrayList<Filme>>{

        @Override
        protected ArrayList<Filme> doInBackground(String... strings) {
            ArrayList<Genero> generos = new ArrayList<>();
            ArrayList<Filme> filmes = new ArrayList<>();
            ArrayList<Poster> imagens = new ArrayList<>();
            try {
                generos = FilmeNetwork.buscarGeneros(strings[1]);
                filmes = FilmeNetwork.buscarFilmes(strings[0]);
                for(Filme filme: filmes){
                    int posicao = generos.indexOf(filme.getGenero());
                    if(posicao >= 0){
                        filme.setGenero(generos.get(posicao));
                    }
                    String urlDir2 = String.format(strings[2],filme.getId());
                    String diretor = FilmeNetwork.buscarDiretores(urlDir2);
                    filme.setDiretor(diretor);
                    String poster = filme.getPosterPath();
                    Bitmap img = FilmeNetwork.buscarImagens(imgUrl+poster);
                    Poster p = new Poster();
                    p.setId(filme.getId());
                    p.setTitulo(filme.getTitulo());
                    p.setPoster(img);
                    imagens.add(p);
                }
                Dados.setImagens(imagens);
                FilmeDb db = new FilmeDb(context);
                db.salvarFilmes(filmes);
                db.atualizaPosters(imagens);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return filmes;
        }

        protected void onPostExecute(ArrayList<Filme> filmes){
            Intent intent = new Intent(context, ListarFilmesActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(FILMES, filmes);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }

    private class CarregaFilmesDb extends AsyncTask<String, Void, ArrayList<Filme>>{

        @Override
        protected ArrayList<Filme> doInBackground(String... strings) {
            FilmeDb db = new FilmeDb(context);
            ArrayList<Filme> filmes = db.buscarFilmes();
            ArrayList<Poster> posters = db.buscaPosters();
            Dados.setImagens(posters);

            return filmes;
        }

        @Override
        protected void onPostExecute(ArrayList<Filme> filmes) {
            Intent intent = new Intent(context, ListarFilmesActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(FILMES, filmes);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }










    private String getKey(){
        return "85e742c42ec7ea587bbb90e414db7ab7";
    }


}

