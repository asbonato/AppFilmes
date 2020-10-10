package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Filme;
import br.usjt.ads20.appfilmes.model.FilmeDb;
import br.usjt.ads20.appfilmes.model.FilmeNetwork;
import br.usjt.ads20.appfilmes.model.Poster;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class DetalheFilmeActivity extends AppCompatActivity {
    private TextView titulo, genero, direcao, lancamento, popularidade, descricao;
    private ImageView backdrop;
    private ProgressBar progressBar;
    private Filme filme;
    private String imgUrl = "https://image.tmdb.org/t/p/w780";
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        context = this;
        titulo = (TextView)findViewById(R.id.txt_titulo);
        genero = (TextView)findViewById(R.id.txt_genero);
        direcao = (TextView)findViewById(R.id.txt_direcao);
        lancamento = (TextView)findViewById(R.id.txt_lancamento);
        popularidade = (TextView)findViewById(R.id.txt_popularidade);
        descricao = (TextView)findViewById(R.id.txt_descricao);
        backdrop = (ImageView)findViewById(R.id.backdropView);
        Intent intent = getIntent();
        filme = (Filme)intent.getSerializableExtra(ListarFilmesActivity.FILME);
        titulo.setText(filme.getTitulo());
        genero.setText(filme.getGenero().getNome());
        direcao.setText(filme.getDiretor());
        descricao.setText(filme.getDescricao());
        lancamento.setText(String.format("%td-%tb-%ty", filme.getDataLancamento(),
                filme.getDataLancamento(), filme.getDataLancamento()));
        popularidade.setText(String.format("%.1f", filme.getPopularidade()));
        progressBar = (ProgressBar)findViewById(R.id.progressBarDetalhe);
        if (FilmeNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            new DownloadBackdrop().execute(filme);
        } else {
            String msg = this.getResources().getString(R.string.erro_rede);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
            progressBar.setVisibility(View.VISIBLE);
            new CarregaBackdropDb().execute(filme);
        }
    }

    private class DownloadBackdrop extends AsyncTask<Filme, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Filme... filmes) {
            Bitmap img = null;
            try {
                img = FilmeNetwork.buscarImagens(imgUrl+filmes[0].getBackdropPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            FilmeDb db = new FilmeDb(context);
            db.atualizaBackdrop(filmes[0].getId(), img);
            return img;
        }

        protected void onPostExecute(Bitmap img){
            backdrop.setImageBitmap(img);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private class CarregaBackdropDb extends AsyncTask<Filme, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(Filme... filmes) {
            Bitmap img = null;
            FilmeDb db = new FilmeDb(context);
            img = db.buscaBackdrop(filmes[0].getId());

            return img;
        }

        @Override
        protected void onPostExecute(Bitmap img){
            if (img != null) {
                backdrop.setImageBitmap(img);
            }
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}