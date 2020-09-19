package br.usjt.ads20.appfilmes;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewHolder {
    private ImageView posterFilme;
    private TextView nomeFilme, detalhe1Filme,detalhe2Filme,detalhe3Filme,detalhe4Filme;

    public ViewHolder(ImageView posterFilme, TextView nomeFilme, TextView detalhe1Filme, TextView detalhe2Filme, TextView detalhe3Filme, TextView detalhe4Filme) {
        this.posterFilme = posterFilme;
        this.nomeFilme = nomeFilme;
        this.detalhe1Filme = detalhe1Filme;
        this.detalhe2Filme = detalhe2Filme;
        this.detalhe3Filme = detalhe3Filme;
        this.detalhe4Filme = detalhe4Filme;
    }

    public ImageView getPosterFilme() {
        return posterFilme;
    }

    public void setPosterFilme(ImageView posterFilme) {
        this.posterFilme = posterFilme;
    }

    public TextView getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(TextView nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public TextView getDetalhe1Filme() {
        return detalhe1Filme;
    }

    public void setDetalhe1Filme(TextView detalhe1Filme) {
        this.detalhe1Filme = detalhe1Filme;
    }

    public TextView getDetalhe2Filme() {
        return detalhe2Filme;
    }

    public void setDetalhe2Filme(TextView detalhe2Filme) {
        this.detalhe2Filme = detalhe2Filme;
    }

    public TextView getDetalhe3Filme() {
        return detalhe3Filme;
    }

    public void setDetalhe3Filme(TextView detalhe3Filme) {
        this.detalhe3Filme = detalhe3Filme;
    }

    public TextView getDetalhe4Filme() {
        return detalhe4Filme;
    }

    public void setDetalhe4Filme(TextView detalhe4Filme) {
        this.detalhe4Filme = detalhe4Filme;
    }
}
