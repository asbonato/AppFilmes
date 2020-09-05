package br.usjt.ads20.appfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheFilmeActivity extends AppCompatActivity {
    private TextView nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        nome = (TextView) findViewById(R.id.filme_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(ListarFilmesActivity.DESCRICAO));
    }
}