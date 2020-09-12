package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.appfilmes.model.Filme;

public class FilmeAdapter extends BaseAdapter {
    private Filme[] filmes;
    private Context context;

    public FilmeAdapter(Context context, Filme[] filmes) {
        this.filmes = filmes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return filmes.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >=0 && i < filmes.length) {
            return filmes[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_filme, viewGroup, false);
            ImageView posterFilme = (ImageView) view.findViewById(R.id.poster_filme);
            TextView nomeFilme = (TextView) view.findViewById(R.id.nome_filme);
            TextView detalheFilme = (TextView) view.findViewById(R.id.detalhe_filme);
            view.setTag(new ViewHolder(posterFilme, nomeFilme, detalheFilme));
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        Drawable drawable = Util.getDrawable(context,
                filmes[i].getPosterPath().substring(0,
                        filmes[i].getPosterPath().length()-4).toLowerCase());
        holder.getPosterFilme().setImageDrawable(drawable);
        holder.getNomeFilme().setText(filmes[i].getTitulo());
        holder.getDetalheFilme().setText(String.format("%s - direção: %s", filmes[i].getGenero().getNome(),
                filmes[i].getDiretor()));

        return view;
    }
}
