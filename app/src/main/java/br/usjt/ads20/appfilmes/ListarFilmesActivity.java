package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Dados;
import br.usjt.ads20.appfilmes.model.Filme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarFilmesActivity extends AppCompatActivity {
    public static final String DESCRICAO = "br.usjt.ads20.appfilmes.descricao";
    Filme[] lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = Dados.buscaFilmes(chave);
        BaseAdapter adapter = new FilmeAdapter(this, lista);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalheFilmeActivity.class);
                intent1.putExtra(DESCRICAO, lista[i].getTitulo());
                startActivity(intent1);
            }
        });

    }


}