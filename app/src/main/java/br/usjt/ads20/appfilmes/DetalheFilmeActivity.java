package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.appfilmes.model.Filme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalheFilmeActivity extends AppCompatActivity {
    private TextView titulo, genero, direcao, lancamento, popularidade, descricao;
    private ImageView backdrop;
    private Filme filme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        titulo = (TextView)findViewById(R.id.txt_titulo);
        genero = (TextView)findViewById(R.id.txt_genero);
        direcao = (TextView)findViewById(R.id.txt_direcao);
        lancamento = (TextView)findViewById(R.id.txt_lancamento);
        popularidade = (TextView)findViewById(R.id.txt_popularidade);
        descricao = (TextView)findViewById(R.id.txt_descricao);
        Intent intent = getIntent();
        filme = (Filme)intent.getSerializableExtra(ListarFilmesActivity.FILME);
        titulo.setText(filme.getTitulo());
        genero.setText(filme.getGenero().getNome());
        direcao.setText(filme.getDiretor());
        descricao.setText(filme.getDescricao());
        lancamento.setText(String.format("%td-%tb-%ty", filme.getDataLancamento(),
                filme.getDataLancamento(), filme.getDataLancamento()));
        popularidade.setText(String.format("%.1f", filme.getPopularidade()));
    }
}