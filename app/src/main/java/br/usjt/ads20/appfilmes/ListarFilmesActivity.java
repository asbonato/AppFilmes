package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarFilmesActivity extends AppCompatActivity {
    public static final String DESCRICAO = "br.usjt.ads20.appfilmes.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaFilmes(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalheFilmeActivity.class);
                intent1.putExtra(DESCRICAO, lista.get(i));
                startActivity(intent1);
            }
        });

    }

    private ArrayList<String> buscaFilmes(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if(chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> filtro = new ArrayList<>();
            for(String nome: lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(nome);
                }
            }
            return filtro;
        }
    }
    private ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Aventura: Guerra nas Estrelas (1977)");
        lista.add("Fantasia: O Senhor dos Anéis: O Retorno do Rei");
        lista.add("Ação: Matrix");
        lista.add("Aventura: De Volta para o Futuro");
        lista.add("Ficção Científica: Jornada nas Estrelas");
        lista.add("Aventura: Os Goonies");
        lista.add("Ficção Científica: Blade Runner, o Caçador de Androides");
        lista.add("Suspense: Allien");
        lista.add("Drama: Platoon");
        lista.add("Ação: Os Vingadores");
        lista.add("Thriller: Pulp Fiction");
        lista.add("Aventura: Os Caçadores da Arca Perdida");
        lista.add("Terror: It - A coisa");
        lista.add("Terror: Psicose");
        lista.add("Comédia: Monty Python em Busca do Cálice Sagrado");
        lista.add("Terror: Os Garotos Perdidos");
        lista.add("Suspense: Seven, os Sete Pecados Capitais");
        lista.add("Ação: Kill Bill");
        lista.add("Fantasia: Alice no País das Maravilhas");
        lista.add("Anime: Akira");
        lista.add("Terror: Hereditário");
        return lista;
    }
}