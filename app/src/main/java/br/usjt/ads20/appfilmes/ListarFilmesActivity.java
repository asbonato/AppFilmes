package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Filme;
import br.usjt.ads20.appfilmes.model.FilmeNetwork;
import br.usjt.ads20.appfilmes.model.Poster;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class ListarFilmesActivity extends AppCompatActivity {
    public static final String FILME = "br.usjt.ads20.appfilmes.filme";
    Filme[] lista;
    Poster[] posters;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        ArrayList<Filme> filmes = (ArrayList<Filme>) intent.getSerializableExtra(MainActivity.FILMES);
        Dados.setFilmes(filmes);

        lista = Dados.buscaFilmes(chave);
        posters = Dados.buscaPosters(chave);

        BaseAdapter adapter = new FilmeAdapter(this, lista, posters);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalheFilmeActivity.class);
                intent1.putExtra(FILME, lista[i]);
                startActivity(intent1);
            }
        });

    }

}