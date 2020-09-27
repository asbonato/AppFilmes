package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Filme;
import br.usjt.ads20.appfilmes.model.FilmeNetwork;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String FILMES = "br.usjt.ads20.appfilmes.filmes";
    private String url = "https://api.themoviedb.org/3/movie/popular?" +
            "language=en-US&page=1&api_key=";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        context = this;
    }

    public void buscarFilmes(View view){
        new DownloadJsonFilmes().execute(url+getKey());
    }

    private class DownloadJsonFilmes extends AsyncTask<String, Void, ArrayList<Filme>>{

        @Override
        protected ArrayList<Filme> doInBackground(String... strings) {
            ArrayList<Filme> filmes = new ArrayList<>();
            try {
                filmes = FilmeNetwork.buscarFilmes(strings[0]);
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
            startActivity(intent);
        }
    }










    private String getKey(){
        return "coloque aqui sua API Key";
    }


}

